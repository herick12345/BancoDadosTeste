package projeto.model.id;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;

@Data
public class JovemRequisitoEspecialidadeId implements Serializable {

    private int idJovem;
    private int idRequisito;

    public JovemRequisitoEspecialidadeId() {}

    public JovemRequisitoEspecialidadeId(int idJovem, int idRequisito) {
        this.idJovem = idJovem;
        this.idRequisito = idRequisito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JovemRequisitoEspecialidadeId)) return false;
        JovemRequisitoEspecialidadeId that = (JovemRequisitoEspecialidadeId) o;
        return idJovem == that.idJovem && idRequisito == that.idRequisito;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJovem, idRequisito);
    }
}