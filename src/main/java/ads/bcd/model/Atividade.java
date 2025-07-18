package ads.bcd.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


@Data
@Entity
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAtividade;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String desc;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date data;

    protected Atividade() {
    }

    public Atividade(String desc, Date data) {
        this.desc = desc;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Atividade [idAtividade=" + idAtividade + ", desc=" + desc + ", data=" + data + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idAtividade == null) ? 0 : idAtividade.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Atividade other = (Atividade) obj;
        return idAtividade != null && idAtividade.equals(other.idAtividade);
    }
}