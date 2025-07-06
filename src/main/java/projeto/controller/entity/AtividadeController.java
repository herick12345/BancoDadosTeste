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

import projeto.model.entity.Atividade;
import projeto.repository.AtividadeRepository;

@RestController
@RequestMapping("/atividade")
public class AtividadeController {

    @Autowired
    private AtividadeRepository repository;

    @GetMapping
    public List<Atividade> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Atividade> getById(@PathVariable Integer id) {
        return repository.findById(id);
    }

    @PostMapping
    public Atividade create(@RequestBody Atividade atividade) {
        return repository.save(atividade);
    }



    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
