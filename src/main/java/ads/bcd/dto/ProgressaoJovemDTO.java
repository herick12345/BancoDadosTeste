package ads.bcd.dto;

import java.util.List;
import java.util.Map; // Mantenha Map por enquanto para "especialidades" como você tinha

public class ProgressaoJovemDTO {
    private JovemDTO jovem; // Agora é JovemDTO
    private List<Map<String, Object>> especialidades; // Mantenha como Map por enquanto

    // Getters e Setters
    public JovemDTO getJovem() {
        return jovem;
    }

    public void setJovem(JovemDTO jovem) {
        this.jovem = jovem;
    }

    public List<Map<String, Object>> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Map<String, Object>> especialidades) {
        this.especialidades = especialidades;
    }
}