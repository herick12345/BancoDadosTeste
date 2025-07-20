package ads.bcd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ads.bcd.model.Jovem;

public interface JovemRepository extends CrudRepository<Jovem, Integer> {

    List<Jovem> findByNome(String nome);
    
    List<Jovem> findByTipoSanguineo(String tipoSanguineo);
}