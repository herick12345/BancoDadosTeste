package projeto.model.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import projeto.model.id.InsigniaJovemId;

@Entity
@Data
@IdClass(InsigniaJovemId.class)
public class InsigniaJovem implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(nullable = false)
    private Jovem idJovem;

    @Id
    @ManyToOne
    @JoinColumn(nullable = false)
    private Insignia idInsignia;

    public InsigniaJovem() {
    }

    public InsigniaJovem(Jovem idJovem, Insignia idInsignia) {
        this.idJovem = idJovem;
        this.idInsignia = idInsignia;
    }
}
