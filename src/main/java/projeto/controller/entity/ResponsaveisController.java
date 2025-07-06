package projeto.controller.entity;

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

import projeto.model.entity.Responsaveis;
import projeto.repository.ResponsaveisRepository;

@RestController
@RequestMapping("/responsaveis")
public class ResponsaveisController {

    @Autowired
    private ResponsaveisRepository repository;

    @GetMapping
    public List<Responsaveis> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Responsaveis> getById(@PathVariable Integer id) {
        return repository.findById(id);
    }

    @PostMapping
    public Responsaveis create(@RequestBody Responsaveis obj) {
        return repository.save(obj);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
