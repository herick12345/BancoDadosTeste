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
@Table(name = "requisito_distintivo")
public class RequisitoDistintivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRequisitoDistintivo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    protected RequisitoDistintivo() {
    }

    public RequisitoDistintivo(String descricao) {
        this.descricao = descricao;
    }
}