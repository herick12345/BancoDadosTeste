package projeto.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContato;

    @Column(nullable = false, length = 20)
    private String telefone;

    @Column(nullable = false, length = 255)
    private String endereco;

    @Column(nullable = false, length = 100)
    private String email;

    public Contato() {
    }

    public Contato(String telefone, String endereco, String email) {
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
    }

    public Contato(int idContato, String telefone, String endereco, String email) {
        this.idContato = idContato;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
    }
}