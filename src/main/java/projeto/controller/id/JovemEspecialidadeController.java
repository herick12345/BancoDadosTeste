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

import projeto.model.entity.JovemEspecialidade;
import projeto.model.id.JovemEspecialidadeId;
import projeto.repository.JovemEspecialidadeRepository;

@RestController
@RequestMapping("/jovem-especialidade")
public class JovemEspecialidadeController {

    @Autowired
    private JovemEspecialidadeRepository repository;

    @GetMapping
    public List<JovemEspecialidade> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{idJovem}/{idEspecialidade}")
    public Optional<JovemEspecialidade> getById(@PathVariable Integer idJovem, @PathVariable Integer idEspecialidade) {
        JovemEspecialidadeId id = new JovemEspecialidadeId(idJovem, idEspecialidade);
        return repository.findById(id);
    }

    @PostMapping
    public JovemEspecialidade create(@RequestBody JovemEspecialidade obj) {
        return repository.save(obj);
    }

    @DeleteMapping("/{idJovem}/{idEspecialidade}")
    public void delete(@PathVariable Integer idJovem, @PathVariable Integer idEspecialidade) {
        JovemEspecialidadeId id = new JovemEspecialidadeId(idJovem, idEspecialidade);
        repository.deleteById(id);
    }
}