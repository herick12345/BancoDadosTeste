package projeto.model.id;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;
@Data

public class ParticipacaoAtividadeId implements Serializable {

    private int idAtividade;
    private int idJovem;

    public ParticipacaoAtividadeId() {}

    public ParticipacaoAtividadeId(int idAtividade, int idJovem) {
        this.idAtividade = idAtividade;
        this.idJovem = idJovem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParticipacaoAtividadeId)) return false;
        ParticipacaoAtividadeId that = (ParticipacaoAtividadeId) o;
        return idAtividade == that.idAtividade && idJovem == that.idJovem;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAtividade, idJovem);
    }
}
