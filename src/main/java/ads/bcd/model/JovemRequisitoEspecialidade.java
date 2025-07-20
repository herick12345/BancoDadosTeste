package ads.bcd.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@IdClass(JovemRequisitoEspecialidadeId.class)
@Table(name = "jovem_requisito_especialidade")
public class JovemRequisitoEspecialidade {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jovem")
    private Jovem jovem;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_requisito")
    private RequisitoEspecialidade requisito;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_cumprimento", nullable = false) // <-- ADDED name="data_cumprimento" HERE
    private Date data;

    protected JovemRequisitoEspecialidade() {
    }

    public JovemRequisitoEspecialidade(Jovem jovem, RequisitoEspecialidade requisito, Date data) {
        this.jovem = jovem;
        this.requisito = requisito;
        this.data = data;
    }

}