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

import projeto.model.entity.ERequisitoInsignia;
import projeto.model.id.ERequisitoInsigniaId;
import projeto.repository.ERequisitoInsigniaRepository;

@RestController
@RequestMapping("/erequisito-insignia")
public class ERequisitoInsigniaController {

    @Autowired
    private ERequisitoInsigniaRepository repository;

    @GetMapping
    public List<ERequisitoInsignia> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{idInsignia}/{idRequisitoInsignia}")
    public Optional<ERequisitoInsignia> getById(@PathVariable Integer idInsignia, @PathVariable Integer idRequisitoInsignia) {
        ERequisitoInsigniaId id = new ERequisitoInsigniaId(idInsignia, idRequisitoInsignia);
        return repository.findById(id);
    }

    @PostMapping
    public ERequisitoInsignia create(@RequestBody ERequisitoInsignia obj) {
        return repository.save(obj);
    }



    @DeleteMapping("/{idInsignia}/{idRequisitoInsignia}")
    public void delete(@PathVariable Integer idInsignia, @PathVariable Integer idRequisitoInsignia) {
        ERequisitoInsigniaId id = new ERequisitoInsigniaId(idInsignia, idRequisitoInsignia);
        repository.deleteById(id);
    }
}
