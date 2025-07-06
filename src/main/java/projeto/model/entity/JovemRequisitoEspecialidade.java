package projeto.model.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import projeto.model.id.JovemRequisitoEspecialidadeId;

@Entity
@Data
@IdClass(JovemRequisitoEspecialidadeId.class)
public class JovemRequisitoEspecialidade implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(nullable = false)
    private Jovem idJovem;

    @Id
    @ManyToOne
    @JoinColumn(nullable = false)
    private RequisitosEspecialidade idRequisito;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataCumprimento;

    public JovemRequisitoEspecialidade() {
    }

    public JovemRequisitoEspecialidade(Jovem idJovem, RequisitosEspecialidade idRequisito, Date dataCumprimento) {
        this.idJovem = idJovem;
        this.idRequisito = idRequisito;
        this.dataCumprimento = dataCumprimento;
    }
}