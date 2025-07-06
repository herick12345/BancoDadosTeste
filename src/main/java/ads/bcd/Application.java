package ads.bcd;

import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ads.bcd.model.AreaConhecimento;
import ads.bcd.model.Contato;
import ads.bcd.model.DistintivosDeProgressao;
import ads.bcd.model.Especialidade;
import ads.bcd.model.Insignia;
import ads.bcd.model.Jovem;
import ads.bcd.model.Responsaveis;
import ads.bcd.repository.AreaConhecimentoRepository;
import ads.bcd.repository.ContatoRepository;
import ads.bcd.repository.DistintivosDeProgressaoRepository;
import ads.bcd.repository.EspecialidadeRepository;
import ads.bcd.repository.InsigniaRepository;
import ads.bcd.repository.JovemRepository;
import ads.bcd.repository.ResponsaveisRepository;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    JovemRepository jovemRepository;

    @Autowired
    ContatoRepository contatoRepository;

    @Autowired
    ResponsaveisRepository responsaveisRepository;

    @Autowired
    AreaConhecimentoRepository areaConhecimentoRepository;

    @Autowired
    EspecialidadeRepository especialidadeRepository;

    @Autowired
    InsigniaRepository insigniaRepository;

    @Autowired
    DistintivosDeProgressaoRepository distintivosRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("Aplicação finalizada");
    }

    @Bean
    public CommandLineRunner demoEscoteiro() {
        return (args) -> {
            try {
                log.info("Iniciando aplicação do Sistema Escoteiro");
                this.povoarBase();
                this.listandoRegistros();
            } catch (Exception e) {
                log.error(e.toString());
            }
        };
    }

    private void povoarBase() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Criando áreas de conhecimento
        AreaConhecimento cienciaTecnologia = new AreaConhecimento("Ciência e Tecnologia");
        AreaConhecimento cultura = new AreaConhecimento("Cultura");
        AreaConhecimento desportos = new AreaConhecimento("Desportos");
        AreaConhecimento habilidadesEscoteiras = new AreaConhecimento("Habilidades Escoteiras");
        AreaConhecimento servicos = new AreaConhecimento("Serviços");

        areaConhecimentoRepository.save(cienciaTecnologia);
        areaConhecimentoRepository.save(cultura);
        areaConhecimentoRepository.save(desportos);
        areaConhecimentoRepository.save(habilidadesEscoteiras);
        areaConhecimentoRepository.save(servicos);

        // Criando contatos
        Contato contatoJoao = new Contato("48999990000", "Rua das Acácias, 100", "joao@email.com");
        Contato contatoMaria = new Contato("48988881111", "Rua das Palmeiras, 200", "maria@email.com");

        contatoRepository.save(contatoJoao);
        contatoRepository.save(contatoMaria);

        // Criando responsáveis
        Responsaveis carlos = new Responsaveis("Carlos Silva", "carlos@email.com", "48991234567");
        Responsaveis ana = new Responsaveis("Ana Souza", "ana@email.com", "48997654321");

        responsaveisRepository.save(carlos);
        responsaveisRepository.save(ana);

        // Criando jovens
        Jovem joao = new Jovem("João Lobinho", sdf.parse("2015-04-20"), sdf.parse("2022-01-15"), 
                              "O+", "Nenhuma", contatoJoao);
        Jovem maria = new Jovem("Maria Escoteira", sdf.parse("2014-09-10"), sdf.parse("2021-09-01"), 
                               "A-", "Alergia a amendoim", contatoMaria);

        jovemRepository.save(joao);
        jovemRepository.save(maria);

        // Criando especialidades
        Especialidade radioamadorismo = new Especialidade("Radioamadorismo", 1, 12, cienciaTecnologia);
        Especialidade criptografia = new Especialidade("Criptografia", 1, 12, cienciaTecnologia);
        Especialidade animaisPeconhentos = new Especialidade("Animais Peçonhentos", 1, 9, cienciaTecnologia);

        especialidadeRepository.save(radioamadorismo);
        especialidadeRepository.save(criptografia);
        especialidadeRepository.save(animaisPeconhentos);

        // Criando distintivos de progressão
        DistintivosDeProgressao loboPata = new DistintivosDeProgressao("Lobo Pata Tenra");
        DistintivosDeProgressao loboSaltador = new DistintivosDeProgressao("Lobo Saltador");
        DistintivosDeProgressao loboRastreador = new DistintivosDeProgressao("Lobo Rastreador");
        DistintivosDeProgressao loboCacador = new DistintivosDeProgressao("Lobo Caçador");
        DistintivosDeProgressao cruzeiroSul = new DistintivosDeProgressao("Cruzeiro do Sul");

        distintivosRepository.save(loboPata);
        distintivosRepository.save(loboSaltador);
        distintivosRepository.save(loboRastreador);
        distintivosRepository.save(loboCacador);
        distintivosRepository.save(cruzeiroSul);

        // Criando insígnias
        Insignia aprender = new Insignia("Aprender");
        Insignia servir = new Insignia("Servir");

        insigniaRepository.save(aprender);
        insigniaRepository.save(servir);

        log.info("Base de dados povoada com sucesso!");
    }

    private void listandoRegistros() throws Exception {
        System.out.println("----------- Todos os Jovens ---------------------");
        for (Jovem jovem : jovemRepository.findAll()) {
            System.out.println(jovem);
        }

        System.out.println("----------- Todas as Especialidades ---------------------");
        for (Especialidade esp : especialidadeRepository.findAll()) {
            System.out.println(esp);
        }

        System.out.println("----------- Todos os Distintivos ---------------------");
        for (DistintivosDeProgressao dist : distintivosRepository.findAll()) {
            System.out.println(dist);
        }

        System.out.println("----------- Busca por jovem específico ---------------------");
        List<Jovem> resultado = jovemRepository.findByNome("João Lobinho");
        resultado.forEach(System.out::println);

        System.out.println("-----------------------------------------------");
    }
}