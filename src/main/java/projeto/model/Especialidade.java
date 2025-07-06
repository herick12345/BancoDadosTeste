package projeto.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEspecialidade;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false)
    private int nivel;

    @Column(nullable = false)
    private int totalRequisitos;

    public Especialidade() {
    }

    public Especialidade(String descricao, int nivel, int totalRequisitos) {
        this.descricao = descricao;
        this.nivel = nivel;
        this.totalRequisitos = totalRequisitos;
    }

    public Especialidade(int idEspecialidade, String descricao, int nivel, int totalRequisitos) {
        this.idEspecialidade = idEspecialidade;
        this.descricao = descricao;
        this.nivel = nivel;
        this.totalRequisitos = totalRequisitos;
    }
}
