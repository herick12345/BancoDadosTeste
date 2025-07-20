package ads.bcd.model;

import java.io.Serializable;
import java.util.Objects; // Importar Objects

// Removido @Data do Lombok. Implementaremos equals/hashCode manualmente.
public class JovemRequisitoEspecialidadeId implements Serializable {
    private Integer jovem;
    private Integer requisito;

    public JovemRequisitoEspecialidadeId() {
    }

    public JovemRequisitoEspecialidadeId(Integer jovem, Integer requisito) {
        this.jovem = jovem;
        this.requisito = requisito;
    }

    // Getters e Setters (essenciais para JPA e para o @IdClass)
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

    // --- Implementação ESSENCIAL de equals() e hashCode() ---
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JovemRequisitoEspecialidadeId that = (JovemRequisitoEspecialidadeId) o;
        // Importante: use Objects.equals para lidar com valores nulos
        return Objects.equals(jovem, that.jovem) &&
               Objects.equals(requisito, that.requisito);
    }

    @Override
    public int hashCode() {
        // Importante: use Objects.hash para gerar o hash code
        return Objects.hash(jovem, requisito);
    }
}