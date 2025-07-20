
package ads.bcd.dto;

import lombok.Data;

@Data
public class EspecialidadeDTO {
    private Integer idEspecialidade;
    private String descricao;
    private Integer nivel;
    private Integer totalRequisitos;
    private AreaConhecimentoDTO areaConhecimento;

}