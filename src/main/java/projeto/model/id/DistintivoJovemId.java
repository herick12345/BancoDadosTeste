package projeto.model.id;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;
@Data


public class DistintivoJovemId implements Serializable {

    private int idDistintivo;
    private int idJovem;

    public DistintivoJovemId() {}

    public DistintivoJovemId(int idDistintivo, int idJovem) {
        this.idDistintivo = idDistintivo;
        this.idJovem = idJovem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DistintivoJovemId)) return false;
        DistintivoJovemId that = (DistintivoJovemId) o;
        return idDistintivo == that.idDistintivo && idJovem == that.idJovem;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDistintivo, idJovem);
    }
}
