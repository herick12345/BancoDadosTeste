package ads.bcd.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ads.bcd.dto.ProgressaoJovemDTO;
import ads.bcd.dto.RequisitoProgressaoDTO;
import ads.bcd.model.JovemRequisitoEspecialidade;
import ads.bcd.service.ProgressaoService;

@RestController
@RequestMapping("/api/progressao")
@CrossOrigin(origins = "*")
public class ProgressaoController {

    @Autowired
    private ProgressaoService progressaoService;

    @GetMapping("/jovem/{idJovem}")
    public ResponseEntity<ProgressaoJovemDTO> obterProgressaoJovem(@PathVariable Integer idJovem) {
        ProgressaoJovemDTO progressao = progressaoService.obterProgressaoJovem(idJovem);
        return ResponseEntity.ok(progressao);
    }

    @GetMapping("/jovem/{idJovem}/especialidade/{idEspecialidade}")
    public ResponseEntity<Map<String, Object>> obterProgressaoEspecialidade(
            @PathVariable Integer idJovem, 
            @PathVariable Integer idEspecialidade) {
        Map<String, Object> progressao = progressaoService.obterProgressaoEspecialidade(idJovem, idEspecialidade);
        return ResponseEntity.ok(progressao);
    }

    @PostMapping("/requisito")
    public ResponseEntity<JovemRequisitoEspecialidade> registrarRequisito(@RequestBody RequisitoProgressaoDTO dto) {
        JovemRequisitoEspecialidade requisito = progressaoService.registrarRequisito(dto);
        return ResponseEntity.ok(requisito);
    }

    @GetMapping("/cruzeiro-do-sul")
    public ResponseEntity<List<Map<String, Object>>> jovensAptosCruzeiroDoSul() {
        List<Map<String, Object>> jovens = progressaoService.jovensAptosCruzeiroDoSul();
        return ResponseEntity.ok(jovens);
    }
}