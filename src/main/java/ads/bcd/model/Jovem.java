package ads.bcd.model;

import java.time.LocalDate; 

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column; 
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "jovem") 
public class Jovem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJovem; // Agora corresponde diretamente à coluna idJovem no DB

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false) // Não precisa de @Temporal com LocalDate
    private LocalDate dataNasc;

    @Column(nullable = false) // Não precisa de @Temporal com LocalDate
    private LocalDate dataEntrada;

    @Column(nullable = false, length = 10)
    private String tipoSanguineo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String alergias;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_contato", referencedColumnName = "idContato") 
    private Contato contato;

    protected Jovem() {
    }

    public Jovem(String nome, LocalDate dataNasc, LocalDate dataEntrada, String tipoSanguineo, String alergias, Contato contato) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.dataEntrada = dataEntrada;
        this.tipoSanguineo = tipoSanguineo;
        this.alergias = alergias;
        this.contato = contato;
    }

    // O @Data do Lombok já gera o toString(), mas você pode sobrescrevê-lo para depuração
    @Override
    public String toString() {
        return "Jovem{" +
               "idJovem=" + idJovem +
               ", nome='" + nome + '\'' +
               ", dataNasc=" + dataNasc +
               ", dataEntrada=" + dataEntrada +
               ", tipoSanguineo='" + tipoSanguineo + '\'' +
               ", alergias='" + alergias + '\'' +
               ", contatoId=" + (contato != null ? contato.getIdContato() : "null") +
               '}';
    }
}