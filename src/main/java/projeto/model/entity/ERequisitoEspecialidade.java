package projeto.model.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import projeto.model.id.ERequisitoEspecialidadeId;

@Entity
@Data
@IdClass(ERequisitoEspecialidadeId.class)
public class ERequisitoEspecialidade implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(nullable = false)
    private Especialidade idEspecialidade;

    @Id
    @ManyToOne
    @JoinColumn(nullable = false)
    private RequisitosEspecialidade idRequisito;

    public ERequisitoEspecialidade() {
    }

    public ERequisitoEspecialidade(Especialidade idEspecialidade, RequisitosEspecialidade idRequisito) {
        this.idEspecialidade = idEspecialidade;
        this.idRequisito = idRequisito;
    }
}
