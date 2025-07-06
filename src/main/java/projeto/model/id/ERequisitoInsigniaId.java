package projeto.model.id;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;
@Data

public class ERequisitoInsigniaId implements Serializable {

    private int idInsignia;
    private int idRequisitoInsignia;

    public ERequisitoInsigniaId() {}

    public ERequisitoInsigniaId(int idInsignia, int idRequisitoInsignia) {
        this.idInsignia = idInsignia;
        this.idRequisitoInsignia = idRequisitoInsignia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ERequisitoInsigniaId)) return false;
        ERequisitoInsigniaId that = (ERequisitoInsigniaId) o;
        return idInsignia == that.idInsignia && idRequisitoInsignia == that.idRequisitoInsignia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInsignia, idRequisitoInsignia);
    }
}
