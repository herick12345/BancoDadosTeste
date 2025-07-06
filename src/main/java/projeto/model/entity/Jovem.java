package projeto.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Jovem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idJovem;

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

    @ManyToOne
    @JoinColumn(name = "idContato", nullable = false)
    private Contato contato;

    public Jovem() {
    }

    public Jovem(String nome, Date dataNasc, Date dataEntrada, String tipoSanguineo, String alergias, Contato contato) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.dataEntrada = dataEntrada;
        this.tipoSanguineo = tipoSanguineo;
        this.alergias = alergias;
        this.contato = contato;
    }

    public Jovem(int idJovem, String nome, Date dataNasc, Date dataEntrada, String tipoSanguineo, String alergias, Contato contato) {
        this.idJovem = idJovem;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.dataEntrada = dataEntrada;
        this.tipoSanguineo = tipoSanguineo;
        this.alergias = alergias;
        this.contato = contato;
    }
}