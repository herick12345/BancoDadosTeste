package projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.model.entity.InsigniaJovem;
import projeto.model.id.InsigniaJovemId;

public interface InsigniaJovemRepository extends JpaRepository<InsigniaJovem, InsigniaJovemId> {
}
