package ads.bcd.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import ads.bcd.model.Especialidade;

public interface EspecialidadeRepository extends CrudRepository<Especialidade, Integer> {
    
    List<Especialidade> findByNivel(Integer nivel);
}