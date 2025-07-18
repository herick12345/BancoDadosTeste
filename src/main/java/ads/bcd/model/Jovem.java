package ads.bcd.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
public class Jovem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJovem;

    @Column(nullable = false, length = 100)
    private String nome;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataNasc;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataEntrada;

    @Column(nullable = false, length = 10)
    private String tipoSanguineo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String alergias;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idContato")
    private Contato contato;

    protected Jovem() {
    }

    public Jovem(String nome, Date dataNasc, Date dataEntrada, String tipoSanguineo, String alergias, Contato contato) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.dataEntrada = dataEntrada;
        this.tipoSanguineo = tipoSanguineo;
        this.alergias = alergias;
        this.contato = contato;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Jovem [idJovem=").append(idJovem)
          .append(", nome=").append(nome)
          .append(", dataNasc=").append(dataNasc)
          .append(", dataEntrada=").append(dataEntrada)
          .append(", tipoSanguineo=").append(tipoSanguineo)
          .append(", alergias=").append(alergias);
        if (this.contato != null) {
            sb.append(", contato=").append(contato);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idJovem == null) ? 0 : idJovem.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Jovem other = (Jovem) obj;
        return idJovem != null && idJovem.equals(other.idJovem);
    }
}