package projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.model.entity.ERequisitoInsignia;
import projeto.model.id.ERequisitoInsigniaId;

public interface ERequisitoInsigniaRepository extends JpaRepository<ERequisitoInsignia, ERequisitoInsigniaId> {
}
