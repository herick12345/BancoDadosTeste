package projeto.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Progressao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProgressao;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date data;

    @Column(nullable = false, length = 100)
    private String progressao;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Jovem idJovem;

    public Progressao() {
    }

    public Progressao(Date data, String progressao, Jovem idJovem) {
        this.data = data;
        this.progressao = progressao;
        this.idJovem = idJovem;
    }

    public Progressao(int idProgressao, Date data, String progressao, Jovem idJovem) {
        this.idProgressao = idProgressao;
        this.data = data;
        this.progressao = progressao;
        this.idJovem = idJovem;
    }
}
