package projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.model.entity.DistintivoJovem;
import projeto.model.id.DistintivoJovemId;

public interface DistintivoJovemRepository extends JpaRepository<DistintivoJovem, DistintivoJovemId> {
}
