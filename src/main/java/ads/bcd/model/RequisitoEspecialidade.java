package ads.bcd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "requisito_especialidade")
public class RequisitoEspecialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRequisito;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String requisito;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_especialidade")
    private Especialidade especialidade;

    protected RequisitoEspecialidade() {
    }

    public RequisitoEspecialidade(String requisito, Especialidade especialidade) {
        this.requisito = requisito;
        this.especialidade = especialidade;
    }

    public Integer getIdRequisito() {
        return idRequisito;
    }

    public String getRequisito() {
        return requisito;
    }

    public Object getEspecialidade() {
        return especialidade;
    }

    public void setIdRequisito(Integer idRequisito) {
        this.idRequisito = idRequisito;
    }

    public void setRequisito(String requisito) {
        this.requisito = requisito;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

}