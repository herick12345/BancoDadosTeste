package ads.bcd.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import ads.bcd.dto.AreaConhecimentoDTO;
import ads.bcd.dto.EspecialidadeDTO;
import ads.bcd.dto.JovemDTO;
import ads.bcd.dto.JovemRequisitoEspecialidadeDTO;
import ads.bcd.dto.ProgressaoJovemDTO;
import ads.bcd.dto.RequisitoEspecialidadeDTO;
import ads.bcd.dto.RequisitoProgressaoDTO;
import ads.bcd.model.AreaConhecimento;
import ads.bcd.model.Especialidade;
import ads.bcd.model.Jovem;
import ads.bcd.model.JovemRequisitoEspecialidade;
import ads.bcd.model.RequisitoEspecialidade;
import ads.bcd.repository.EspecialidadeRepository;
import ads.bcd.repository.JovemRepository;
import ads.bcd.repository.JovemRequisitoEspecialidadeRepository;
import ads.bcd.repository.RequisitoEspecialidadeRepository;

@Service
public class ProgressaoService {

    // Constantes para mensagens e chaves de mapa (melhora a manutenibilidade)
    private static final String JOVEM_NAO_ENCONTRADO_MSG = "Jovem não encontrado";
    private static final String ESPECIALIDADE_NAO_ENCONTRADA_MSG = "Especialidade não encontrada";
    private static final String REQUISITO_NAO_ENCONTRADO_MSG = "Requisito não encontrado";
    private static final String REQUISITOS_COMPLETOS_KEY = "requisitos_completos";
    private static final String JOVEM_KEY = "jovem";
    private static final String ESPECIALIDADE_KEY = "especialidade";
    private static final String TOTAL_REQUISITOS_KEY = "total_requisitos";
    private static final String NIVEL_KEY = "nivel";
    private static final String PERCENTUAL_KEY = "percentual";
    private static final String TODOS_REQUISITOS_KEY = "todos_requisitos";


    private final JovemRepository jovemRepository;
    private final EspecialidadeRepository especialidadeRepository;
    private final RequisitoEspecialidadeRepository requisitoEspecialidadeRepository;
    private final JovemRequisitoEspecialidadeRepository jovemRequisitoEspecialidadeRepository;

    public ProgressaoService(JovemRepository jovemRepository,
                             EspecialidadeRepository especialidadeRepository,
                             RequisitoEspecialidadeRepository requisitoEspecialidadeRepository,
                             JovemRequisitoEspecialidadeRepository jovemRequisitoEspecialidadeRepository) {
        this.jovemRepository = jovemRepository;
        this.especialidadeRepository = especialidadeRepository;
        this.requisitoEspecialidadeRepository = requisitoEspecialidadeRepository;
        this.jovemRequisitoEspecialidadeRepository = jovemRequisitoEspecialidadeRepository;
    }

    public ProgressaoJovemDTO obterProgressaoJovem(Integer idJovem) {
        Jovem jovem = jovemRepository.findById(idJovem)
                .orElseThrow(() -> new RuntimeException(JOVEM_NAO_ENCONTRADO_MSG));

        ProgressaoJovemDTO dto = new ProgressaoJovemDTO();
        dto.setJovem(convertToJovemDTO(jovem));

        List<Map<String, Object>> especialidades = new ArrayList<>();
        
        for (Especialidade esp : especialidadeRepository.findAll()) {
            Map<String, Object> espMap = new HashMap<>();
            espMap.put(ESPECIALIDADE_KEY, convertToEspecialidadeDTO(esp));
            
            long requisitosCompletos = jovemRequisitoEspecialidadeRepository
                    .countByJovemIdJovemAndRequisitoEspecialidadeIdEspecialidade(idJovem, esp.getIdEspecialidade());
            
            int nivel = calcularNivel(requisitosCompletos, esp.getTotalRequisitos());
            
            espMap.put(REQUISITOS_COMPLETOS_KEY, requisitosCompletos);
            espMap.put(TOTAL_REQUISITOS_KEY, esp.getTotalRequisitos());
            espMap.put(NIVEL_KEY, nivel);
            espMap.put(PERCENTUAL_KEY, (double) requisitosCompletos / esp.getTotalRequisitos() * 100);
            
            especialidades.add(espMap);
        }

        dto.setEspecialidades(especialidades);
        return dto;
    }

    public Map<String, Object> obterProgressaoEspecialidade(Integer idJovem, Integer idEspecialidade) {
        Jovem jovem = jovemRepository.findById(idJovem)
                .orElseThrow(() -> new RuntimeException(JOVEM_NAO_ENCONTRADO_MSG));
        
        Especialidade especialidade = especialidadeRepository.findById(idEspecialidade)
                .orElseThrow(() -> new RuntimeException(ESPECIALIDADE_NAO_ENCONTRADA_MSG));

        List<RequisitoEspecialidade> todosRequisitos = requisitoEspecialidadeRepository
                .findByEspecialidadeIdEspecialidade(idEspecialidade);
        
        List<JovemRequisitoEspecialidade> requisitosCompletos = jovemRequisitoEspecialidadeRepository
                .findByJovemIdJovemAndRequisitoEspecialidadeIdEspecialidade(idJovem, idEspecialidade);

        Map<String, Object> resultado = new HashMap<>();
        resultado.put(JOVEM_KEY, convertToJovemDTO(jovem));
        resultado.put(ESPECIALIDADE_KEY, convertToEspecialidadeDTO(especialidade));
        
        resultado.put(TODOS_REQUISITOS_KEY, todosRequisitos.stream()
                                                        .map(this::convertToRequisitoEspecialidadeDTO)
                                                        .toList()); // Usando .toList() para Java 16+
        
        resultado.put(REQUISITOS_COMPLETOS_KEY, requisitosCompletos.stream()
                                                        .map(this::convertToJovemRequisitoEspecialidadeDTO)
                                                        .toList()); // Usando .toList() para Java 16+

        resultado.put(NIVEL_KEY, calcularNivel(requisitosCompletos.size(), especialidade.getTotalRequisitos()));
        resultado.put(PERCENTUAL_KEY, (double) requisitosCompletos.size() / especialidade.getTotalRequisitos() * 100);

        return resultado;
    }

    public JovemRequisitoEspecialidade registrarRequisito(RequisitoProgressaoDTO dto) {
        Jovem jovem = jovemRepository.findById(dto.getIdJovem())
                .orElseThrow(() -> new RuntimeException(JOVEM_NAO_ENCONTRADO_MSG));
        
        RequisitoEspecialidade requisito = requisitoEspecialidadeRepository.findById(dto.getIdRequisito())
                .orElseThrow(() -> new RuntimeException(REQUISITO_NAO_ENCONTRADO_MSG));

        JovemRequisitoEspecialidade jovemRequisito = new JovemRequisitoEspecialidade(
                jovem, requisito, new Date());

        return jovemRequisitoEspecialidadeRepository.save(jovemRequisito);
    }

    public List<Map<String, Object>> jovensAptosCruzeiroDoSul() {
        List<Map<String, Object>> jovensAptos = new ArrayList<>();
        
        for (Jovem jovem : jovemRepository.findAll()) {
            List<JovemRequisitoEspecialidade> requisitos = jovemRequisitoEspecialidadeRepository
                    .findByJovemIdJovem(jovem.getIdJovem());
            
            if (requisitos.size() >= 15) { // Critério para "Cruzeiro do Sul"
                Map<String, Object> jovemApto = new HashMap<>();
                jovemApto.put(JOVEM_KEY, convertToJovemDTO(jovem));
                jovemApto.put(REQUISITOS_COMPLETOS_KEY, requisitos.size());
                jovensAptos.add(jovemApto);
            }
        }
        
        return jovensAptos;
    }

    private int calcularNivel(long requisitosCompletos, int totalRequisitos) {
        double percentual = (double) requisitosCompletos / totalRequisitos;
        
        if (percentual >= 1.0) return 3; // Nível 3 (100% ou mais)
        if (percentual >= 0.67) return 2; // Nível 2 (acima de 67%)
        if (percentual >= 0.33) return 1; // Nível 1 (acima de 33%)
        return 0; // Nível 0 (abaixo de 33%)
    }

    // --- Métodos de Conversão (Mappers) ---

    private JovemDTO convertToJovemDTO(Jovem jovem) {
        JovemDTO dto = new JovemDTO();
        dto.setIdJovem(jovem.getIdJovem());
        dto.setNome(jovem.getNome());
        return dto;
    }

    private EspecialidadeDTO convertToEspecialidadeDTO(Especialidade especialidade) {
        EspecialidadeDTO dto = new EspecialidadeDTO();
        dto.setIdEspecialidade(especialidade.getIdEspecialidade());
        dto.setDescricao(especialidade.getDescricao());
        dto.setNivel(especialidade.getNivel());
        dto.setTotalRequisitos(especialidade.getTotalRequisitos());

        if (especialidade.getAreaConhecimento() != null) {
            dto.setAreaConhecimento(convertToAreaConhecimentoDTO(especialidade.getAreaConhecimento()));
        }

        return dto;
    }

    private AreaConhecimentoDTO convertToAreaConhecimentoDTO(AreaConhecimento areaConhecimento) {
        AreaConhecimentoDTO dto = new AreaConhecimentoDTO();
        dto.setIdAreaConhecimento(areaConhecimento.getIdAreaConhecimento());
        dto.setNome(areaConhecimento.getNome());
        return dto;
    }

// ... (previous code)

    private RequisitoEspecialidadeDTO convertToRequisitoEspecialidadeDTO(RequisitoEspecialidade requisito) {
        RequisitoEspecialidadeDTO dto = new RequisitoEspecialidadeDTO();
        dto.setIdRequisito(requisito.getIdRequisito());
        dto.setRequisito(requisito.getRequisito()); 
        
        // --- CORRECTION HERE ---
        // Explicitly cast to Especialidade to resolve the 'Object cannot be converted to Especialidade' error.
        // The null check is still important to prevent NullPointerExceptions.
        if (requisito.getEspecialidade() != null) {
             dto.setEspecialidade(convertToEspecialidadeDTO((Especialidade) requisito.getEspecialidade())); // <-- Cast added here
        }
        return dto;
    }

// ... (rest of the code)

    private JovemRequisitoEspecialidadeDTO convertToJovemRequisitoEspecialidadeDTO(JovemRequisitoEspecialidade jre) {
        JovemRequisitoEspecialidadeDTO dto = new JovemRequisitoEspecialidadeDTO();
        // Para entidades com @IdClass, a chave composta é formada pelas referências às entidades.
        // Copiamos os DTOs das entidades que compõem a chave.
        dto.setJovem(convertToJovemDTO(jre.getJovem()));
        dto.setRequisito(convertToRequisitoEspecialidadeDTO(jre.getRequisito()));
        dto.setData(jre.getData()); 

        return dto;
    }
}