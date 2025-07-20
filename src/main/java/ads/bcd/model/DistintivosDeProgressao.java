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
@Table(name = "distintivos_de_progressao")
public class DistintivosDeProgressao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDistintivo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    protected DistintivosDeProgressao() {
    }

    public DistintivosDeProgressao(String descricao) {
        this.descricao = descricao;
    }

}