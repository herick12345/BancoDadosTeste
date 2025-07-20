package ads.bcd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "requisitos_insignia")
public class RequisitosInsignia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRequisitoInsignia;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_Insignia")
    private Insignia insignia;

    protected RequisitosInsignia() {
    }

    public RequisitosInsignia(String descricao, Insignia insignia) {
        this.descricao = descricao;
        this.insignia = insignia;
    }
}