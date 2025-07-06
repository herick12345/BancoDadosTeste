package projeto.model.id;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;
@Data
public class ProgRequisitoId implements Serializable {

    private int idDistintivo;
    private int idRequisitoDistintivo;

    public ProgRequisitoId() {}

    public ProgRequisitoId(int idDistintivo, int idRequisitoDistintivo) {
        this.idDistintivo = idDistintivo;
        this.idRequisitoDistintivo = idRequisitoDistintivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProgRequisitoId)) return false;
        ProgRequisitoId that = (ProgRequisitoId) o;
        return idDistintivo == that.idDistintivo && idRequisitoDistintivo == that.idRequisitoDistintivo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDistintivo, idRequisitoDistintivo);
    }
}
