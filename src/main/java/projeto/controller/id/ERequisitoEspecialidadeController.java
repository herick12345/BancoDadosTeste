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

import projeto.model.entity.ERequisitoEspecialidade;
import projeto.model.id.ERequisitoEspecialidadeId;
import projeto.repository.ERequisitoEspecialidadeRepository;

@RestController
@RequestMapping("/erequisito-especialidade")
public class ERequisitoEspecialidadeController {

    @Autowired
    private ERequisitoEspecialidadeRepository repository;

    @GetMapping
    public List<ERequisitoEspecialidade> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{idEspecialidade}/{idRequisito}")
    public Optional<ERequisitoEspecialidade> getById(@PathVariable Integer idEspecialidade, @PathVariable Integer idRequisito) {
        ERequisitoEspecialidadeId id = new ERequisitoEspecialidadeId(idEspecialidade, idRequisito);
        return repository.findById(id);
    }

    @PostMapping
    public ERequisitoEspecialidade create(@RequestBody ERequisitoEspecialidade obj) {
        return repository.save(obj);
    }



    @DeleteMapping("/{idEspecialidade}/{idRequisito}")
    public void delete(@PathVariable Integer idEspecialidade, @PathVariable Integer idRequisito) {
        ERequisitoEspecialidadeId id = new ERequisitoEspecialidadeId(idEspecialidade, idRequisito);
        repository.deleteById(id);
    }
}
