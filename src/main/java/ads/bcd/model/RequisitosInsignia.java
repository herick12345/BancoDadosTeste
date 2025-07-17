package ads.bcd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RequisitosInsignia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRequisitoInsignia;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String desc;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_Insignia")
    private Insignia insignia;

    protected RequisitosInsignia() {
    }

    public RequisitosInsignia(String desc, Insignia insignia) {
        this.desc = desc;
        this.insignia = insignia;
    }

    public Integer getIdRequisitoInsignia() {
        return idRequisitoInsignia;
    }

    public void setIdRequisitoInsignia(Integer idRequisitoInsignia) {
        this.idRequisitoInsignia = idRequisitoInsignia;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Insignia getInsignia() {
        return insignia;
    }

    public void setInsignia(Insignia insignia) {
        this.insignia = insignia;
    }

    @Override
    public String toString() {
        return "RequisitosInsignia [idRequisitoInsignia=" + idRequisitoInsignia + ", desc=" + desc + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idRequisitoInsignia == null) ? 0 : idRequisitoInsignia.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        RequisitosInsignia other = (RequisitosInsignia) obj;
        return idRequisitoInsignia != null && idRequisitoInsignia.equals(other.idRequisitoInsignia);
    }
}