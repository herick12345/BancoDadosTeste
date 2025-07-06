package projeto.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class RequisitosEspecialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRequisito;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String requisito;

    public RequisitosEspecialidade() {
    }

    public RequisitosEspecialidade(String requisito) {
        this.requisito = requisito;
    }

    public RequisitosEspecialidade(int idRequisito, String requisito) {
        this.idRequisito = idRequisito;
        this.requisito = requisito;
    }
}