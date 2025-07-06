package projeto.model.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import projeto.model.id.JovemResponsavelId;

@Entity
@Data
@IdClass(JovemResponsavelId.class)
public class JovemResponsavel implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(nullable = false)
    private Jovem idJovem;

    @Id
    @ManyToOne
    @JoinColumn(nullable = false)
    private Responsaveis idResponsavel;

    public JovemResponsavel() {
    }

    public JovemResponsavel(Jovem idJovem, Responsaveis idResponsavel) {
        this.idJovem = idJovem;
        this.idResponsavel = idResponsavel;
    }
}
