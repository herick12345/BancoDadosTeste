package ads.bcd.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import ads.bcd.model.Jovem;

public interface JovemRepository extends CrudRepository<Jovem, Integer> {
    
    /**
     * Busca jovens pelo nome
     */
    List<Jovem> findByNome(String nome);
    
    /**
     * Busca jovens pelo tipo sanguíneo
     */
    List<Jovem> findByTipoSanguineo(String tipoSanguineo);
}