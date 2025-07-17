package ads.bcd.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import ads.bcd.model.JovemRequisitoEspecialidade;
import ads.bcd.model.JovemRequisitoEspecialidadeId;

public interface JovemRequisitoEspecialidadeRepository extends CrudRepository<JovemRequisitoEspecialidade, JovemRequisitoEspecialidadeId> {
    
    /**
     * Busca requisitos cumpridos por um jovem
     */
    List<JovemRequisitoEspecialidade> findByJovemIdJovem(Integer idJovem);
    
    /**
     * Busca requisitos cumpridos por um jovem para uma especialidade específica
     */
    List<JovemRequisitoEspecialidade> findByJovemIdJovemAndRequisitoEspecialidadeIdEspecialidade(Integer idJovem, Integer idEspecialidade);
    
    /**
     * Conta quantos requisitos um jovem cumpriu para uma especialidade
     */
    long countByJovemIdJovemAndRequisitoEspecialidadeIdEspecialidade(Integer idJovem, Integer idEspecialidade);
}