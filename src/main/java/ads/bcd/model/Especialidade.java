package ads.bcd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
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
    @JoinColumn(name = "idAreaConhecimento")
    private AreaConhecimento areaConhecimento;

    protected Especialidade() {
    }

    public Especialidade(String descricao, Integer nivel, Integer totalRequisitos, AreaConhecimento areaConhecimento) {
        this.descricao = descricao;
        this.nivel = nivel;
        this.totalRequisitos = totalRequisitos;
        this.areaConhecimento = areaConhecimento;
    }

    public Integer getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(Integer idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getTotalRequisitos() {
        return totalRequisitos;
    }

    public void setTotalRequisitos(Integer totalRequisitos) {
        this.totalRequisitos = totalRequisitos;
    }

    public AreaConhecimento getAreaConhecimento() {
        return areaConhecimento;
    }

    public void setAreaConhecimento(AreaConhecimento areaConhecimento) {
        this.areaConhecimento = areaConhecimento;
    }

    @Override
    public String toString() {
        return "Especialidade [idEspecialidade=" + idEspecialidade + 
               ", descricao=" + descricao + ", nivel=" + nivel + 
               ", totalRequisitos=" + totalRequisitos + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idEspecialidade == null) ? 0 : idEspecialidade.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Especialidade other = (Especialidade) obj;
        return idEspecialidade != null && idEspecialidade.equals(other.idEspecialidade);
    }
}