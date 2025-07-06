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

import projeto.model.entity.JovemRequisitoEspecialidade;
import projeto.model.id.JovemRequisitoEspecialidadeId;
import projeto.repository.JovemRequisitoEspecialidadeRepository;

@RestController
@RequestMapping("/jovem-requisito-especialidade")
public class JovemRequisitoEspecialidadeController {

    @Autowired
    private JovemRequisitoEspecialidadeRepository repository;

    @GetMapping
    public List<JovemRequisitoEspecialidade> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{idJovem}/{idRequisito}")
    public Optional<JovemRequisitoEspecialidade> getById(@PathVariable Integer idJovem, @PathVariable Integer idRequisito) {
        JovemRequisitoEspecialidadeId id = new JovemRequisitoEspecialidadeId(idJovem, idRequisito);
        return repository.findById(id);
    }

    @PostMapping
    public JovemRequisitoEspecialidade create(@RequestBody JovemRequisitoEspecialidade obj) {
        return repository.save(obj);
    }

    @DeleteMapping("/{idJovem}/{idRequisito}")
    public void delete(@PathVariable Integer idJovem, @PathVariable Integer idRequisito) {
        JovemRequisitoEspecialidadeId id = new JovemRequisitoEspecialidadeId(idJovem, idRequisito);
        repository.deleteById(id);
    }
}