package ads.bcd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ads.bcd.model.Jovem;
import ads.bcd.service.JovemService;

@RestController
@RequestMapping("/api/jovens")
@CrossOrigin(origins = "*")
public class JovemController {

    @Autowired
    private JovemService jovemService;

    @GetMapping
    public List<Jovem> listarTodos() {
        return jovemService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jovem> buscarPorId(@PathVariable Integer id) {
        Optional<Jovem> jovem = jovemService.buscarPorId(id);
        return jovem.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Jovem criar(@RequestBody Jovem jovem) {
        return jovemService.salvar(jovem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jovem> atualizar(@PathVariable Integer id, @RequestBody Jovem jovem) {
        if (!jovemService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        jovem.setIdJovem(id);
        return ResponseEntity.ok(jovemService.salvar(jovem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if (!jovemService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        jovemService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nome/{nome}")
    public List<Jovem> buscarPorNome(@PathVariable String nome) {
        return jovemService.buscarPorNome(nome);
    }
}