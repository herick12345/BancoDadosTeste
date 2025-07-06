package projeto.controller.id;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.model.entity.ParticipacaoAtividade;
import projeto.model.id.ParticipacaoAtividadeId;
import projeto.repository.ParticipacaoAtividadeRepository;

@RestController
@RequestMapping("/participacao-atividade")
public class ParticipacaoAtividadeController {

    @Autowired
    private ParticipacaoAtividadeRepository repository;

    @GetMapping
    public List<ParticipacaoAtividade> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{idAtividade}/{idJovem}")
    public Optional<ParticipacaoAtividade> getById(@PathVariable Integer idAtividade, @PathVariable Integer idJovem) {
        ParticipacaoAtividadeId id = new ParticipacaoAtividadeId(idAtividade, idJovem);
        return repository.findById(id);
    }

    @PostMapping
    public ParticipacaoAtividade create(@RequestBody ParticipacaoAtividade obj) {
        return repository.save(obj);
    }



    @DeleteMapping("/{idAtividade}/{idJovem}")
    public void delete(@PathVariable Integer idAtividade, @PathVariable Integer idJovem) {
        ParticipacaoAtividadeId id = new ParticipacaoAtividadeId(idAtividade, idJovem);
        repository.deleteById(id);
    }
}
