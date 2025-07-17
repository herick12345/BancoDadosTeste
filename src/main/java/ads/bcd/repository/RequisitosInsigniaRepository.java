package ads.bcd.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import ads.bcd.model.RequisitosInsignia;

public interface RequisitosInsigniaRepository extends CrudRepository<RequisitosInsignia, Integer> {
    
    /**
     * Busca requisitos por insígnia
     */
    List<RequisitosInsignia> findByInsigniaIdInsignia(Integer idInsignia);
}