package projeto.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class RequisitosInsignia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRequisitoInsignia;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String desc;

    public RequisitosInsignia() {
    }

    public RequisitosInsignia(String desc) {
        this.desc = desc;
    }

    public RequisitosInsignia(int idRequisitoInsignia, String desc) {
        this.idRequisitoInsignia = idRequisitoInsignia;
        this.desc = desc;
    }
}
