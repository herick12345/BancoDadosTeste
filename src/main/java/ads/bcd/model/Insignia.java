package ads.bcd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Insignia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInsignia;

    @Column(nullable = false, length = 100)
    private String nome;

    protected Insignia() {
    }

    public Insignia(String nome) {
        this.nome = nome;
    }

    public Integer getIdInsignia() {
        return idInsignia;
    }

    public void setIdInsignia(Integer idInsignia) {
        this.idInsignia = idInsignia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Insignia [idInsignia=" + idInsignia + ", nome=" + nome + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idInsignia == null) ? 0 : idInsignia.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Insignia other = (Insignia) obj;
        return idInsignia != null && idInsignia.equals(other.idInsignia);
    }
}