package ads.bcd.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import ads.bcd.model.RequisitoEspecialidade;

public interface RequisitoEspecialidadeRepository extends CrudRepository<RequisitoEspecialidade, Integer> {
    
    /**
     * Busca requisitos por especialidade
     */
    List<RequisitoEspecialidade> findByEspecialidadeIdEspecialidade(Integer idEspecialidade);
}