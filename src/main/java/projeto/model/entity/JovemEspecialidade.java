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
import projeto.model.id.JovemEspecialidadeId;

@Entity
@Data
@IdClass(JovemEspecialidadeId.class)
public class JovemEspecialidade implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(nullable = false)
    private Jovem idJovem;

    @Id
    @ManyToOne
    @JoinColumn(nullable = false)
    private Especialidade idEspecialidade;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataConquista;

    public JovemEspecialidade() {
    }

    public JovemEspecialidade(Jovem idJovem, Especialidade idEspecialidade, Date dataConquista) {
        this.idJovem = idJovem;
        this.idEspecialidade = idEspecialidade;
        this.dataConquista = dataConquista;
    }
}