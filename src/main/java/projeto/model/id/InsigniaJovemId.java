package projeto.model.id;

import java.io.Serializable;
import java.util.Objects;
import lombok.Data;
@Data

public class InsigniaJovemId implements Serializable {

    private int idJovem;
    private int idInsignia;

    public InsigniaJovemId() {}

    public InsigniaJovemId(int idJovem, int idInsignia) {
        this.idJovem = idJovem;
        this.idInsignia = idInsignia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InsigniaJovemId)) return false;
        InsigniaJovemId that = (InsigniaJovemId) o;
        return idJovem == that.idJovem && idInsignia == that.idInsignia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJovem, idInsignia);
    }
}
