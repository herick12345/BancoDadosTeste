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

import projeto.model.entity.InsigniaJovem;
import projeto.model.id.InsigniaJovemId;
import projeto.repository.InsigniaJovemRepository;

@RestController
@RequestMapping("/insignia-jovem")
public class InsigniaJovemController {

    @Autowired
    private InsigniaJovemRepository repository;

    @GetMapping
    public List<InsigniaJovem> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{idJovem}/{idInsignia}")
    public Optional<InsigniaJovem> getById(@PathVariable Integer idJovem, @PathVariable Integer idInsignia) {
        InsigniaJovemId id = new InsigniaJovemId(idJovem, idInsignia);
        return repository.findById(id);
    }

    @PostMapping
    public InsigniaJovem create(@RequestBody InsigniaJovem obj) {
        return repository.save(obj);
    }



    @DeleteMapping("/{idJovem}/{idInsignia}")
    public void delete(@PathVariable Integer idJovem, @PathVariable Integer idInsignia) {
        InsigniaJovemId id = new InsigniaJovemId(idJovem, idInsignia);
        repository.deleteById(id);
    }
}
