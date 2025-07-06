package projeto.model.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import projeto.model.id.ProgRequisitoId;

@Entity
@Data
@IdClass(ProgRequisitoId.class)
public class ProgRequisito implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(nullable = false)
    private DistintivosDeProgressao idDistintivo;

    @Id
    @ManyToOne
    @JoinColumn(nullable = false)
    private RequisitosDistintivo idRequisitoDistintivo;

    public ProgRequisito() {
    }

    public ProgRequisito(DistintivosDeProgressao idDistintivo, RequisitosDistintivo idRequisitoDistintivo) {
        this.idDistintivo = idDistintivo;
        this.idRequisitoDistintivo = idRequisitoDistintivo;
    }
}
