package projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.model.entity.ProgRequisito;
import projeto.model.id.ProgRequisitoId;



public interface ProgRequesitoRepository extends JpaRepository<ProgRequisito, ProgRequisitoId> {
}
