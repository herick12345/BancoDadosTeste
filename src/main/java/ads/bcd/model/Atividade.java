package ads.bcd.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


@Data
@Entity
@Table(name = "atividade")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAtividade;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date data;

    protected Atividade() {
    }

    public Atividade(String descricao, Date data) {
        this.descricao = descricao;
        this.data = data;
    }

}