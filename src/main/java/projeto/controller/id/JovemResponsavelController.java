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

import projeto.model.entity.JovemResponsavel;
import projeto.model.id.JovemResponsavelId;
import projeto.repository.JovemResponsavelRepository;

@RestController
@RequestMapping("/jovem-responsavel")
public class JovemResponsavelController {

    @Autowired
    private JovemResponsavelRepository repository;

    @GetMapping
    public List<JovemResponsavel> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{idJovem}/{idResponsavel}")
    public Optional<JovemResponsavel> getById(@PathVariable Integer idJovem, @PathVariable Integer idResponsavel) {
        JovemResponsavelId id = new JovemResponsavelId(idJovem, idResponsavel);
        return repository.findById(id);
    }

    @PostMapping
    public JovemResponsavel create(@RequestBody JovemResponsavel obj) {
        return repository.save(obj);
    }



    @DeleteMapping("/{idJovem}/{idResponsavel}")
    public void delete(@PathVariable Integer idJovem, @PathVariable Integer idResponsavel) {
        JovemResponsavelId id = new JovemResponsavelId(idJovem, idResponsavel);
        repository.deleteById(id);
    }
}
