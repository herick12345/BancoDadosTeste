package ads.bcd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RequisitoDistintivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRequisitoDistintivo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String desc;

    protected RequisitoDistintivo() {
    }

    public RequisitoDistintivo(String desc) {
        this.desc = desc;
    }

    public Integer getIdRequisitoDistintivo() {
        return idRequisitoDistintivo;
    }

    public void setIdRequisitoDistintivo(Integer idRequisitoDistintivo) {
        this.idRequisitoDistintivo = idRequisitoDistintivo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "RequisitoDistintivo [idRequisitoDistintivo=" + idRequisitoDistintivo + ", desc=" + desc + "]";
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