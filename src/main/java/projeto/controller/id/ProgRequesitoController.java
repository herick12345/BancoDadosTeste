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

import projeto.model.entity.ProgRequisito;
import projeto.model.id.ProgRequisitoId;
import projeto.repository.ProgRequesitoRepository;

@RestController
@RequestMapping("/prog-requisito")
public class ProgRequesitoController {

    @Autowired
    private ProgRequesitoRepository repository;

    @GetMapping
    public List<ProgRequisito> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{idDistintivo}/{idRequisitoDistintivo}")
    public Optional<ProgRequisito> getById(@PathVariable Integer idDistintivo, @PathVariable Integer idRequisitoDistintivo) {
        ProgRequisitoId id = new ProgRequisitoId(idDistintivo, idRequisitoDistintivo);
        return repository.findById(id);
    }

    @PostMapping
    public ProgRequisito create(@RequestBody ProgRequisito obj) {
        return repository.save(obj);
    }


    @DeleteMapping("/{idDistintivo}/{idRequisitoDistintivo}")
    public void delete(@PathVariable Integer idDistintivo, @PathVariable Integer idRequisitoDistintivo) {
        ProgRequisitoId id = new ProgRequisitoId(idDistintivo, idRequisitoDistintivo);
        repository.deleteById(id);
    }
}
