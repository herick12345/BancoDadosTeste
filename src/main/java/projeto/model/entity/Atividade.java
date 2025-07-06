package projeto.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAtividade;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String desc;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date data;

    public Atividade() {
    }

    public Atividade(String desc, Date data) {
        this.desc = desc;
        this.data = data;
    }

    public Atividade(int idAtividade, String desc, Date data) {
        this.idAtividade = idAtividade;
        this.desc = desc;
        this.data = data;
    }
}