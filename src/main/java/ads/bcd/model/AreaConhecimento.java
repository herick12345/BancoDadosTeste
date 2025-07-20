package ads.bcd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "area_conhecimento")
public class AreaConhecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAreaConhecimento;

    @Column(nullable = false, length = 50)
    private String nome;

    protected AreaConhecimento() {
    }

    public AreaConhecimento(String nome) {
        this.nome = nome;
    }

}