package ads.bcd.dto;

import ads.bcd.model.Jovem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JovemCruzeiroAptoDTO {
    private Jovem jovem;
    private long requisitosCompletos;
}