package ads.bcd.dto;

import java.util.List;
import java.util.Map;

import ads.bcd.model.Jovem;

public class ProgressaoJovemDTO {
    private Jovem jovem;
    private List<Map<String, Object>> especialidades;

    public Jovem getJovem() {
        return jovem;
    }

    public void setJovem(Jovem jovem) {
        this.jovem = jovem;
    }

    public List<Map<String, Object>> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Map<String, Object>> especialidades) {
        this.especialidades = especialidades;
    }
}