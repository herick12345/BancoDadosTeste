package ads.bcd.dto;

import java.util.Date;

public class JovemRequisitoEspecialidadeDTO {
    private JovemDTO jovem;
    private RequisitoEspecialidadeDTO requisito; // Nome do campo corresponde ao modelo
    private Date data; // Nome do campo corresponde ao modelo (era 'dataConclusao' antes)

    public JovemRequisitoEspecialidadeDTO() {}

    public JovemDTO getJovem() {
        return jovem;
    }

    public void setJovem(JovemDTO jovem) {
        this.jovem = jovem;
    }

    public RequisitoEspecialidadeDTO getRequisito() {
        return requisito;
    }

    public void setRequisito(RequisitoEspecialidadeDTO requisito) {
        this.requisito = requisito;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}