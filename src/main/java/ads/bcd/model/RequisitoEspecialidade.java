package ads.bcd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
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

    @Override
    public String toString() {
        return "RequisitoEspecialidade [idRequisito=" + idRequisito + ", requisito=" + requisito + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idRequisito == null) ? 0 : idRequisito.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        RequisitoEspecialidade other = (RequisitoEspecialidade) obj;
        return idRequisito != null && idRequisito.equals(other.idRequisito);
    }
}