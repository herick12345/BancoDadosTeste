package projeto.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class AreaConhecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAreaConhecimento;

    @Column(nullable = false, length = 50)
    private String nome;

    public AreaConhecimento() {
    }

    public AreaConhecimento(String nome) {
        this.nome = nome;
    }

    public AreaConhecimento(int idAreaConhecimento, String nome) {
        this.idAreaConhecimento = idAreaConhecimento;
        this.nome = nome;
    }
}