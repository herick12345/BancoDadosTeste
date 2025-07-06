package projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.model.entity.Especialidade;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Integer> {
}
