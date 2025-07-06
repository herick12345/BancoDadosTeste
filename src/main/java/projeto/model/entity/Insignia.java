package projeto.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Insignia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInsignia;

    @Column(nullable = false, length = 100)
    private String nome;

    public Insignia() {
    }

    public Insignia(String nome) {
        this.nome = nome;
    }

    public Insignia(int idInsignia, String nome) {
        this.idInsignia = idInsignia;
        this.nome = nome;
    }
}