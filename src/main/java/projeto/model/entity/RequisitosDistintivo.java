package projeto.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class RequisitosDistintivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRequisitoDistintivo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String desc;

    public RequisitosDistintivo() {
    }

    public RequisitosDistintivo(String desc) {
        this.desc = desc;
    }

    public RequisitosDistintivo(int idRequisitoDistintivo, String desc) {
        this.idRequisitoDistintivo = idRequisitoDistintivo;
        this.desc = desc;
    }
}