package projeto.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "idAreaConhecimento", nullable = false)
    private AreaConhecimento areaConhecimento;

    public Especialidade() {
    }

    public Especialidade(String descricao, int nivel, int totalRequisitos, AreaConhecimento areaConhecimento) {
        this.descricao = descricao;
        this.nivel = nivel;
        this.totalRequisitos = totalRequisitos;
        this.areaConhecimento = areaConhecimento;
    }

    public Especialidade(int idEspecialidade, String descricao, int nivel, int totalRequisitos, AreaConhecimento areaConhecimento) {
        this.idEspecialidade = idEspecialidade;
        this.descricao = descricao;
        this.nivel = nivel;
        this.totalRequisitos = totalRequisitos;
        this.areaConhecimento = areaConhecimento;
    }
}