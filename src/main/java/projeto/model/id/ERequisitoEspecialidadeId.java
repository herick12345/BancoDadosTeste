package projeto.model.id;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;
@Data
public class ERequisitoEspecialidadeId implements Serializable {

    private int idEspecialidade;
    private int idRequisito;

    public ERequisitoEspecialidadeId() {}

    public ERequisitoEspecialidadeId(int idEspecialidade, int idRequisito) {
        this.idEspecialidade = idEspecialidade;
        this.idRequisito = idRequisito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ERequisitoEspecialidadeId)) return false;
        ERequisitoEspecialidadeId that = (ERequisitoEspecialidadeId) o;
        return idEspecialidade == that.idEspecialidade && idRequisito == that.idRequisito;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEspecialidade, idRequisito);
    }
}
