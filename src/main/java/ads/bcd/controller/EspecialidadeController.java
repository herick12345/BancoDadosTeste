package ads.bcd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ads.bcd.dto.AreaConhecimentoDTO;
import ads.bcd.dto.EspecialidadeDTO;
import ads.bcd.model.Especialidade;
import ads.bcd.service.EspecialidadeService;

@RestController
@RequestMapping("api/especialidades")
public class EspecialidadeController {

    private final EspecialidadeService especialidadeService;

    public EspecialidadeController(EspecialidadeService especialidadeService) {
        this.especialidadeService = especialidadeService;
    }

    @GetMapping
    public List<EspecialidadeDTO> listarTodas() {
        return especialidadeService.listarTodas().stream().map(this::convertToDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadeDTO> buscarPorId(@PathVariable Integer id) {
        Optional<Especialidade> especialidade = especialidadeService.buscarPorId(id);
        return especialidade.map(this::convertToDTO) // <-- Mudei aqui!
                            .map(ResponseEntity::ok)
                            .orElse(ResponseEntity.notFound().build());
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
    public List<EspecialidadeDTO> buscarPorNivel(@PathVariable Integer nivel) {
        return especialidadeService.buscarPorNivel(nivel).stream()
                .map(this::convertToDTO)
                .toList();
    }


    private EspecialidadeDTO convertToDTO(Especialidade especialidade) {
        EspecialidadeDTO dto = new EspecialidadeDTO();
        dto.setIdEspecialidade(especialidade.getIdEspecialidade());
        dto.setDescricao(especialidade.getDescricao());
        dto.setNivel(especialidade.getNivel());
        dto.setTotalRequisitos(especialidade.getTotalRequisitos());

        if (especialidade.getAreaConhecimento() != null) {
            dto.setAreaConhecimento(convertToDTO(especialidade.getAreaConhecimento()));
        }

        return dto;
    }

    private AreaConhecimentoDTO convertToDTO(ads.bcd.model.AreaConhecimento areaConhecimento) {
        AreaConhecimentoDTO dto = new AreaConhecimentoDTO();
        dto.setIdAreaConhecimento(areaConhecimento.getIdAreaConhecimento());
        dto.setNome(areaConhecimento.getNome());
        return dto;
    }
}