package ads.bcd.repository;

import org.springframework.data.repository.CrudRepository;
import ads.bcd.model.Contato;

public interface ContatoRepository extends CrudRepository<Contato, Integer> {
}