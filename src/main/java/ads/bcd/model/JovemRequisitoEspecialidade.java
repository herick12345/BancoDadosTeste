package ads.bcd.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@IdClass(JovemRequisitoEspecialidadeId.class)
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
    @Column(nullable = false)
    private Date data;

    protected JovemRequisitoEspecialidade() {
    }

    public JovemRequisitoEspecialidade(Jovem jovem, RequisitoEspecialidade requisito, Date data) {
        this.jovem = jovem;
        this.requisito = requisito;
        this.data = data;
    }

    public Jovem getJovem() {
        return jovem;
    }

    public void setJovem(Jovem jovem) {
        this.jovem = jovem;
    }

    public RequisitoEspecialidade getRequisito() {
        return requisito;
    }

    public void setRequisito(RequisitoEspecialidade requisito) {
        this.requisito = requisito;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JovemRequisitoEspecialidade [jovem=" + jovem.getNome() + 
               ", requisito=" + requisito.getRequisito() + ", data=" + data + "]";
    }
}