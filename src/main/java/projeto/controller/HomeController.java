package projeto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Sistema de Registro de Progressões - Ramo Lobinho");
        response.put("version", "1.0.0");
        
        Map<String, String> endpoints = new HashMap<>();
        
        // Endpoints de entidades principais
        endpoints.put("Jovens", "/jovem");
        endpoints.put("Contatos", "/contato");
        endpoints.put("Responsáveis", "/responsaveis");
        endpoints.put("Atividades", "/atividade");
        endpoints.put("Especialidades", "/especialidade");
        endpoints.put("Áreas de Conhecimento", "/area-conhecimento");
        endpoints.put("Insígnias", "/insignia");
        endpoints.put("Distintivos de Progressão", "/distintivos-de-progressao");
        endpoints.put("Requisitos de Especialidade", "/requisito-especialidade");
        endpoints.put("Requisitos de Distintivo", "/requisito-distintivo");
        endpoints.put("Requisitos de Insígnia", "/requisito-insignia");
        endpoints.put("Progressão", "/progressao");
        
        // Endpoints de relacionamentos
        endpoints.put("Jovem-Responsável", "/jovem-responsavel");
        endpoints.put("Jovem-Especialidade", "/jovem-especialidade");
        endpoints.put("Jovem-Requisito-Especialidade", "/jovem-requisito-especialidade");
        endpoints.put("Insígnia-Jovem", "/insignia-jovem");
        endpoints.put("Distintivo-Jovem", "/distintivo-jovem");
        endpoints.put("Participação em Atividades", "/participacao-atividade");
        endpoints.put("Especialidade-Requisito", "/erequisito-especialidade");
        endpoints.put("Insígnia-Requisito", "/erequisito-insignia");
        endpoints.put("Progressão-Requisito", "/prog-requisito");
        
        // Endpoints de relatórios
        endpoints.put("Relatórios", "/relatorios");
        
        response.put("endpoints", endpoints);
        
        Map<String, String> relatorios = new HashMap<>();
        relatorios.put("Dados biográficos de um jovem", "/relatorios/jovem/{id}");
        relatorios.put("Jovens com determinada especialidade", "/relatorios/jovens/especialidade/{idEspecialidade}");
        relatorios.put("Especialidades e insígnias de um jovem", "/relatorios/jovem/{id}/especialidades-insignias");
        relatorios.put("Requisitos cumpridos por jovem para especialidade", "/relatorios/jovem/{idJovem}/especialidade/{idEspecialidade}/requisitos");
        relatorios.put("Jovens aptos para Cruzeiro do Sul", "/relatorios/cruzeiro-do-sul");
        
        response.put("relatorios", relatorios);
        
        Map<String, String> exemplos = new HashMap<>();
        exemplos.put("Listar todos os jovens", "GET /jovem");
        exemplos.put("Obter jovem por ID", "GET /jovem/1");
        exemplos.put("Dados biográficos do jovem 1", "GET /relatorios/jovem/1");
        exemplos.put("Jovens com especialidade 1", "GET /relatorios/jovens/especialidade/1");
        
        response.put("exemplos", exemplos);
        
        return response;
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> status = new HashMap<>();
        status.put("status", "UP");
        status.put("database", "MySQL");
        return status;
    }
}