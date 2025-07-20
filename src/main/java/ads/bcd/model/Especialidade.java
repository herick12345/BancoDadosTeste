package ads.bcd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "especialidade")
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEspecialidade;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false)
    private Integer nivel;

    @Column(nullable = false)
    private Integer totalRequisitos;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_area_conhecimento")
    private AreaConhecimento areaConhecimento;

    protected Especialidade() {
    }

    public Especialidade(String descricao, Integer nivel, Integer totalRequisitos, AreaConhecimento areaConhecimento) {
        this.descricao = descricao;
        this.nivel = nivel;
        this.totalRequisitos = totalRequisitos;
        this.areaConhecimento = areaConhecimento;
    }
}