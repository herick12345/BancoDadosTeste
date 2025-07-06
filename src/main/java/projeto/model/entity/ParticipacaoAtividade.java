package projeto.model.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import projeto.model.id.ParticipacaoAtividadeId;

@Entity
@Data
@IdClass(ParticipacaoAtividadeId.class)
public class ParticipacaoAtividade implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(nullable = false)
    private Atividade idAtividade;

    @Id
    @ManyToOne
    @JoinColumn(nullable = false)
    private Jovem idJovem;

    public ParticipacaoAtividade() {
    }

    public ParticipacaoAtividade(Atividade idAtividade, Jovem idJovem) {
        this.idAtividade = idAtividade;
        this.idJovem = idJovem;
    }
}
