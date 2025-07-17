package ads.bcd.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ads.bcd.dto.ProgressaoJovemDTO;
import ads.bcd.dto.RequisitoProgressaoDTO;
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

    @Autowired
    private JovemRepository jovemRepository;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @Autowired
    private RequisitoEspecialidadeRepository requisitoEspecialidadeRepository;

    @Autowired
    private JovemRequisitoEspecialidadeRepository jovemRequisitoEspecialidadeRepository;

    public ProgressaoJovemDTO obterProgressaoJovem(Integer idJovem) {
        Jovem jovem = jovemRepository.findById(idJovem)
                .orElseThrow(() -> new RuntimeException("Jovem não encontrado"));

        ProgressaoJovemDTO dto = new ProgressaoJovemDTO();
        dto.setJovem(jovem);

        List<Map<String, Object>> especialidades = new ArrayList<>();
        
        for (Especialidade esp : especialidadeRepository.findAll()) {
            Map<String, Object> espMap = new HashMap<>();
            espMap.put("especialidade", esp);
            
            long requisitosCompletos = jovemRequisitoEspecialidadeRepository
                    .countByJovemIdJovemAndRequisitoEspecialidadeIdEspecialidade(idJovem, esp.getIdEspecialidade());
            
            int nivel = calcularNivel(requisitosCompletos, esp.getTotalRequisitos());
            
            espMap.put("requisitosCompletos", requisitosCompletos);
            espMap.put("totalRequisitos", esp.getTotalRequisitos());
            espMap.put("nivel", nivel);
            espMap.put("percentual", (double) requisitosCompletos / esp.getTotalRequisitos() * 100);
            
            especialidades.add(espMap);
        }

        dto.setEspecialidades(especialidades);
        return dto;
    }

    public Map<String, Object> obterProgressaoEspecialidade(Integer idJovem, Integer idEspecialidade) {
        Jovem jovem = jovemRepository.findById(idJovem)
                .orElseThrow(() -> new RuntimeException("Jovem não encontrado"));
        
        Especialidade especialidade = especialidadeRepository.findById(idEspecialidade)
                .orElseThrow(() -> new RuntimeException("Especialidade não encontrada"));

        List<RequisitoEspecialidade> todosRequisitos = requisitoEspecialidadeRepository
                .findByEspecialidadeIdEspecialidade(idEspecialidade);
        
        List<JovemRequisitoEspecialidade> requisitosCompletos = jovemRequisitoEspecialidadeRepository
                .findByJovemIdJovemAndRequisitoEspecialidadeIdEspecialidade(idJovem, idEspecialidade);

        Map<String, Object> resultado = new HashMap<>();
        resultado.put("jovem", jovem);
        resultado.put("especialidade", especialidade);
        resultado.put("todosRequisitos", todosRequisitos);
        resultado.put("requisitosCompletos", requisitosCompletos);
        resultado.put("nivel", calcularNivel(requisitosCompletos.size(), especialidade.getTotalRequisitos()));
        resultado.put("percentual", (double) requisitosCompletos.size() / especialidade.getTotalRequisitos() * 100);

        return resultado;
    }

    public JovemRequisitoEspecialidade registrarRequisito(RequisitoProgressaoDTO dto) {
        Jovem jovem = jovemRepository.findById(dto.getIdJovem())
                .orElseThrow(() -> new RuntimeException("Jovem não encontrado"));
        
        RequisitoEspecialidade requisito = requisitoEspecialidadeRepository.findById(dto.getIdRequisito())
                .orElseThrow(() -> new RuntimeException("Requisito não encontrado"));

        JovemRequisitoEspecialidade jovemRequisito = new JovemRequisitoEspecialidade(
                jovem, requisito, new Date());

        return jovemRequisitoEspecialidadeRepository.save(jovemRequisito);
    }

    public List<Map<String, Object>> jovensAptosCruzeiroDoSul() {
        List<Map<String, Object>> jovensAptos = new ArrayList<>();
        
        for (Jovem jovem : jovemRepository.findAll()) {
            // Verificar se tem pelo menos 5 especialidades em 3 áreas diferentes
            // Esta é uma implementação simplificada - na prática seria mais complexa
            List<JovemRequisitoEspecialidade> requisitos = jovemRequisitoEspecialidadeRepository
                    .findByJovemIdJovem(jovem.getIdJovem());
            
            if (requisitos.size() >= 15) { // Assumindo que 15 requisitos = 5 especialidades básicas
                Map<String, Object> jovemApto = new HashMap<>();
                jovemApto.put("jovem", jovem);
                jovemApto.put("requisitosCompletos", requisitos.size());
                jovensAptos.add(jovemApto);
            }
        }
        
        return jovensAptos;
    }

    private int calcularNivel(long requisitosCompletos, int totalRequisitos) {
        double percentual = (double) requisitosCompletos / totalRequisitos;
        
        if (percentual >= 1.0) return 3;
        if (percentual >= 0.67) return 2;
        if (percentual >= 0.33) return 1;
        return 0;
    }
}