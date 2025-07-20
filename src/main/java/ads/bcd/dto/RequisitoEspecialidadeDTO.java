package ads.bcd.dto;

public class RequisitoEspecialidadeDTO {
    private Integer idRequisito; // Nome do campo corresponde ao modelo
    private String requisito;    // Nome do campo corresponde ao modelo (era 'descricao' antes)
    private EspecialidadeDTO especialidade; // Incluir o DTO da especialidade se relevante

    public RequisitoEspecialidadeDTO() {}

    public Integer getIdRequisito() {
        return idRequisito;
    }

    public void setIdRequisito(Integer idRequisito) {
        this.idRequisito = idRequisito;
    }

    public String getRequisito() { // Getter para o campo 'requisito'
        return requisito;
    }

    public void setRequisito(String requisito) { // Setter para o campo 'requisito'
        this.requisito = requisito;
    }

    public EspecialidadeDTO getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(EspecialidadeDTO especialidade) {
        this.especialidade = especialidade;
    }
}