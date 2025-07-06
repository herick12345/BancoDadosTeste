package projeto.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Jovem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJovem;
    private String nome;
    private LocalDate dataNasc;
    private LocalDate dataEntrada;
    private String tipoSanguineo;
    private String alergias;

    @ManyToOne
    @JoinColumn(name = "idContato")
    private Contato contato;

    @ManyToMany
    @JoinTable(
        name = "Jovem_Responsavel",
        joinColumns = @JoinColumn(name = "id_jovem"),
        inverseJoinColumns = @JoinColumn(name = "id_responsavel")
    )
    private List<Responsavel> responsaveis;

    @ManyToMany
    @JoinTable(
        name = "Participacao_Atividade",
        joinColumns = @JoinColumn(name = "id_jovem"),
        inverseJoinColumns = @JoinColumn(name = "id_atividade")
    )
    private List<Atividade> atividades;

    @OneToMany(mappedBy = "jovem")
    private List<JovemEspecialidade> especialidades;

    @OneToMany(mappedBy = "jovem")
    private List<JovemRequisitoEspecialidade> requisitos;

    @OneToMany(mappedBy = "jovem")
    private List<DistintivoJovem> distintivos;

    @OneToMany(mappedBy = "jovem")
    private List<InsigniaJovem> insignias;

    // Getters e Setters
    public Long getIdJovem() { return idJovem; }
    public void setIdJovem(Long idJovem) { this.idJovem = idJovem; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public LocalDate getDataNasc() { return dataNasc; }
    public void setDataNasc(LocalDate dataNasc) { this.dataNasc = dataNasc; }
    public LocalDate getDataEntrada() { return dataEntrada; }
    public void setDataEntrada(LocalDate dataEntrada) { this.dataEntrada = dataEntrada; }
    public String getTipoSanguineo() { return tipoSanguineo; }
    public void setTipoSanguineo(String tipoSanguineo) { this.tipoSanguineo = tipoSanguineo; }
    public String getAlergias() { return alergias; }
    public void setAlergias(String alergias) { this.alergias = alergias; }
    public Contato getContato() { return contato; }
    public void setContato(Contato contato) { this.contato = contato; }
    public List<Responsavel> getResponsaveis() { return responsaveis; }
    public void setResponsaveis(List<Responsavel> responsaveis) { this.responsaveis = responsaveis; }
    public List<Atividade> getAtividades() { return atividades; }
    public void setAtividades(List<Atividade> atividades) { this.atividades = atividades; }
    public List<JovemEspecialidade> getEspecialidades() { return especialidades; }
    public void setEspecialidades(List<JovemEspecialidade> especialidades) { this.especialidades = especialidades; }
    public List<JovemRequisitoEspecialidade> getRequisitos() { return requisitos; }
    public void setRequisitos(List<JovemRequisitoEspecialidade> requisitos) { this.requisitos = requisitos; }
    public List<DistintivoJovem> getDistintivos() { return distintivos; }
    public void setDistintivos(List<DistintivoJovem> distintivos) { this.distintivos = distintivos; }
    public List<InsigniaJovem> getInsignias() { return insignias; }
    public void setInsignias(List<InsigniaJovem> insignias) { this.insignias = insignias; }
}