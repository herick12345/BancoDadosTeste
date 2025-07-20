package ads.bcd.dto;

import ads.bcd.model.Especialidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EspecialidadeProgressaoDTO {
    private Especialidade especialidade;
    private long requisitosCompletos;
    private int nivel;
    private double percentual;
}