package ads.bcd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class AreaConhecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAreaConhecimento;

    @Column(nullable = false, length = 50)
    private String nome;

    protected AreaConhecimento() {
    }

    public AreaConhecimento(String nome) {
        this.nome = nome;
    }


    @Override
    public String toString() {
        return "AreaConhecimento [idAreaConhecimento=" + idAreaConhecimento + ", nome=" + nome + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idAreaConhecimento == null) ? 0 : idAreaConhecimento.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        AreaConhecimento other = (AreaConhecimento) obj;
        return idAreaConhecimento != null && idAreaConhecimento.equals(other.idAreaConhecimento);
    }
}