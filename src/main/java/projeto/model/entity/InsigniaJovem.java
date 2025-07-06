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

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataConquista;

    public InsigniaJovem() {
    }

    public InsigniaJovem(Jovem idJovem, Insignia idInsignia, Date dataConquista) {
        this.idJovem = idJovem;
        this.idInsignia = idInsignia;
        this.dataConquista = dataConquista;
    }
}