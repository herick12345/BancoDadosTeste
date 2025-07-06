package projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.model.entity.JovemEspecialidade;
import projeto.model.id.JovemEspecialidadeId;

public interface JovemEspecialidadeRepository extends JpaRepository<JovemEspecialidade, JovemEspecialidadeId> {
}