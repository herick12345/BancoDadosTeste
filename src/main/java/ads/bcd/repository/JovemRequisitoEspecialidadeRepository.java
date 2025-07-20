package ads.bcd.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import ads.bcd.model.JovemRequisitoEspecialidade;
import ads.bcd.model.JovemRequisitoEspecialidadeId;

public interface JovemRequisitoEspecialidadeRepository extends CrudRepository<JovemRequisitoEspecialidade, JovemRequisitoEspecialidadeId> {
    
    List<JovemRequisitoEspecialidade> findByJovemIdJovem(Integer idJovem);

    List<JovemRequisitoEspecialidade> findByJovemIdJovemAndRequisitoEspecialidadeIdEspecialidade(Integer idJovem, Integer idEspecialidade);

    long countByJovemIdJovemAndRequisitoEspecialidadeIdEspecialidade(Integer idJovem, Integer idEspecialidade);
}