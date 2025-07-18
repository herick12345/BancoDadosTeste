package ads.bcd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Responsaveis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idResponsavel;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 20)
    private String telefone;

    protected Responsaveis() {
    }

    public Responsaveis(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Responsaveis [idResponsavel=" + idResponsavel + 
               ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idResponsavel == null) ? 0 : idResponsavel.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Responsaveis other = (Responsaveis) obj;
        return idResponsavel != null && idResponsavel.equals(other.idResponsavel);
    }
}