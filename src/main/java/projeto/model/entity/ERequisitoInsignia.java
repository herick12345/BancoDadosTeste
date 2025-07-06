package projeto.model.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import projeto.model.id.ERequisitoInsigniaId;

@Entity
@Data
@IdClass(ERequisitoInsigniaId.class)
public class ERequisitoInsignia implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(nullable = false)
    private Insignia idInsignia;

    @Id
    @ManyToOne
    @JoinColumn(nullable = false)
    private RequisitosInsignia idRequisitoInsignia;

    public ERequisitoInsignia() {
    }

    public ERequisitoInsignia(Insignia idInsignia, RequisitosInsignia idRequisitoInsignia) {
        this.idInsignia = idInsignia;
        this.idRequisitoInsignia = idRequisitoInsignia;
    }
}
