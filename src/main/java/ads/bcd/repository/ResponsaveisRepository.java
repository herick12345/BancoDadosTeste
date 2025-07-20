package ads.bcd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ads.bcd.model.Responsaveis;

public interface ResponsaveisRepository extends CrudRepository<Responsaveis, Integer> {
    
    List<Responsaveis> findByNome(String nome);
}