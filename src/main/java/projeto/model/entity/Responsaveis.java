package projeto.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Responsaveis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResponsavel;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 20)
    private String telefone;

    public Responsaveis() {
    }

    public Responsaveis(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Responsaveis(int idResponsavel, String nome, String email, String telefone) {
        this.idResponsavel = idResponsavel;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
}