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
import projeto.model.id.DistintivoJovemId;

@Entity
@Data
@IdClass(DistintivoJovemId.class)
public class DistintivoJovem implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(nullable = false)
    private DistintivosDeProgressao idDistintivo;

    @Id
    @ManyToOne
    @JoinColumn(nullable = false)
    private Jovem idJovem;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date data;

    public DistintivoJovem() {
    }

    public DistintivoJovem(DistintivosDeProgressao idDistintivo, Jovem idJovem, Date data) {
        this.idDistintivo = idDistintivo;
        this.idJovem = idJovem;
        this.data = data;
    }
}
