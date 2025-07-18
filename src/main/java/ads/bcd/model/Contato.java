package ads.bcd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContato;

    @Column(nullable = false, length = 20)
    private String telefone;

    @Column(nullable = false, length = 255)
    private String endereco;

    @Column(nullable = false, length = 100)
    private String email;

    protected Contato() {
    }

    public Contato(String telefone, String endereco, String email) {
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contato [idContato=" + idContato + ", telefone=" + telefone + 
               ", endereco=" + endereco + ", email=" + email + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idContato == null) ? 0 : idContato.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Contato other = (Contato) obj;
        return idContato != null && idContato.equals(other.idContato);
    }
}