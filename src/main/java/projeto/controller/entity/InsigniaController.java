package projeto.controller.entity;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.model.entity.Insignia;
import projeto.repository.InsigniaRepository;

@RestController
@RequestMapping("/insignia")
public class InsigniaController {

    private InsigniaRepository repository;

    @GetMapping
    public List<Insignia> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Insignia> getById(@PathVariable Integer id) {
        return repository.findById(id);
    }

    @PostMapping
    public Insignia create(@RequestBody Insignia obj) {
        return repository.save(obj);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
