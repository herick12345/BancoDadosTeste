package ads.bcd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class DistintivosDeProgressao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDistintivo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String desc;

    protected DistintivosDeProgressao() {
    }

    public DistintivosDeProgressao(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "DistintivosDeProgressao [idDistintivo=" + idDistintivo + ", desc=" + desc + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idDistintivo == null) ? 0 : idDistintivo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        DistintivosDeProgressao other = (DistintivosDeProgressao) obj;
        return idDistintivo != null && idDistintivo.equals(other.idDistintivo);
    }
}