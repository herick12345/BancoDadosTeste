package ads.bcd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class RequisitoDistintivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRequisitoDistintivo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    protected RequisitoDistintivo() {
    }

    public RequisitoDistintivo(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "RequisitoDistintivo [idRequisitoDistintivo=" + idRequisitoDistintivo + ", descricao=" + descricao + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idRequisitoDistintivo == null) ? 0 : idRequisitoDistintivo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        RequisitoDistintivo other = (RequisitoDistintivo) obj;
        return idRequisitoDistintivo != null && idRequisitoDistintivo.equals(other.idRequisitoDistintivo);
    }
}