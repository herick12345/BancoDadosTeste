package ads.bcd.model;

import java.io.Serializable;
import java.util.Objects;

public class JovemRequisitoEspecialidadeId implements Serializable {
    private Integer jovem;
    private Integer requisito;

    public JovemRequisitoEspecialidadeId() {
    }

    public JovemRequisitoEspecialidadeId(Integer jovem, Integer requisito) {
        this.jovem = jovem;
        this.requisito = requisito;
    }

    public Integer getJovem() {
        return jovem;
    }

    public void setJovem(Integer jovem) {
        this.jovem = jovem;
    }

    public Integer getRequisito() {
        return requisito;
    }

    public void setRequisito(Integer requisito) {
        this.requisito = requisito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JovemRequisitoEspecialidadeId that = (JovemRequisitoEspecialidadeId) o;
        return Objects.equals(jovem, that.jovem) && Objects.equals(requisito, that.requisito);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jovem, requisito);
    }
}