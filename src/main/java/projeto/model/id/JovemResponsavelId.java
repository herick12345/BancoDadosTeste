package projeto.model.id;

import java.io.Serializable;
import java.util.Objects;
import lombok.Data;
@Data

public class JovemResponsavelId implements Serializable {

    private int idJovem;
    private int idResponsavel;

    public JovemResponsavelId() {}

    public JovemResponsavelId(int idJovem, int idResponsavel) {
        this.idJovem = idJovem;
        this.idResponsavel = idResponsavel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JovemResponsavelId)) return false;
        JovemResponsavelId that = (JovemResponsavelId) o;
        return idJovem == that.idJovem && idResponsavel == that.idResponsavel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJovem, idResponsavel);
    }
}
