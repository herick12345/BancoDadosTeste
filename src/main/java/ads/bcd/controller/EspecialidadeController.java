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

import ads.bcd.model.Especialidade;
import ads.bcd.service.EspecialidadeService;

@RestController
@RequestMapping("/api/especialidades")
@CrossOrigin(origins = "*")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeService especialidadeService;

    @GetMapping
    public List<Especialidade> listarTodas() {
        return especialidadeService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidade> buscarPorId(@PathVariable Integer id) {
        Optional<Especialidade> especialidade = especialidadeService.buscarPorId(id);
        return especialidade.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Especialidade criar(@RequestBody Especialidade especialidade) {
        return especialidadeService.salvar(especialidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Especialidade> atualizar(@PathVariable Integer id, @RequestBody Especialidade especialidade) {
        if (!especialidadeService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        especialidade.setIdEspecialidade(id);
        return ResponseEntity.ok(especialidadeService.salvar(especialidade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if (!especialidadeService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        especialidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nivel/{nivel}")
    public List<Especialidade> buscarPorNivel(@PathVariable Integer nivel) {
        return especialidadeService.buscarPorNivel(nivel);
    }
}