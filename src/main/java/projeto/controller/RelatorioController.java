package projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projeto.model.entity.*;
import projeto.repository.*;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private JovemRepository jovemRepository;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @Autowired
    private InsigniaRepository insigniaRepository;

    @Autowired
    private InsigniaJovemRepository insigniaJovemRepository;

    @Autowired
    private DistintivoJovemRepository distintivoJovemRepository;

    @Autowired
    private ParticipacaoAtividadeRepository participacaoAtividadeRepository;

    @Autowired
    private ProgressaoRepository progressaoRepository;

    // 1️⃣ Dados biográficos de um determinado jovem
    @GetMapping("/jovem/{id}")
    public Jovem dadosBiograficos(@PathVariable Integer id) {
        return jovemRepository.findById(id).orElse(null);
    }

    // 2️⃣ Jovens que possuem uma determinada especialidade
    @GetMapping("/jovens/especialidade/{idEspecialidade}")
    public List<Jovem> jovensPorEspecialidade(@PathVariable Integer idEspecialidade) {
        return jovemRepository.findJovensByEspecialidade(idEspecialidade);
    }

    // 3️⃣ Especialidades e insígnias de um determinado jovem
    @GetMapping("/jovem/{id}/especialidades-insignias")
    public List<Object[]> especialidadesInsignias(@PathVariable Integer id) {
        return jovemRepository.findEspecialidadesInsigniasByJovem(id);
    }

    // 4️⃣ Requisitos já cumpridos por um jovem para uma determinada especialidade
    @GetMapping("/jovem/{idJovem}/especialidade/{idEspecialidade}/requisitos")
    public List<Object[]> requisitosCumpridos(@PathVariable Integer idJovem, @PathVariable Integer idEspecialidade) {
        return jovemRepository.findRequisitosCumpridos(idJovem, idEspecialidade);
    }

    // 5️⃣ Jovens que possuem todos os requisitos para o Cruzeiro do Sul
    @GetMapping("/cruzeiro-do-sul")
    public List<Jovem> jovensAptosCruzeiroDoSul() {
        return jovemRepository.findJovensAptosCruzeiroDoSul();
    }
}
