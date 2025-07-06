package projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.model.entity.JovemRequisitoEspecialidade;
import projeto.model.id.JovemRequisitoEspecialidadeId;

public interface JovemRequisitoEspecialidadeRepository extends JpaRepository<JovemRequisitoEspecialidade, JovemRequisitoEspecialidadeId> {
}