package projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.model.entity.ERequisitoEspecialidade;
import projeto.model.id.ERequisitoEspecialidadeId;

public interface ERequisitoEspecialidadeRepository extends JpaRepository<ERequisitoEspecialidade, ERequisitoEspecialidadeId> {
}
