package projeto.model.id;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;

@Data
public class JovemEspecialidadeId implements Serializable {

    private int idJovem;
    private int idEspecialidade;

    public JovemEspecialidadeId() {}

    public JovemEspecialidadeId(int idJovem, int idEspecialidade) {
        this.idJovem = idJovem;
        this.idEspecialidade = idEspecialidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JovemEspecialidadeId)) return false;
        JovemEspecialidadeId that = (JovemEspecialidadeId) o;
        return idJovem == that.idJovem && idEspecialidade == that.idEspecialidade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJovem, idEspecialidade);
    }
}