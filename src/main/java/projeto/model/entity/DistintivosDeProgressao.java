package projeto.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DistintivosDeProgressao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDistintivo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String desc;

    public DistintivosDeProgressao() {
    }

    public DistintivosDeProgressao(String desc) {
        this.desc = desc;
    }

    public DistintivosDeProgressao(int idDistintivo, String desc) {
        this.idDistintivo = idDistintivo;
        this.desc = desc;
    }
}
