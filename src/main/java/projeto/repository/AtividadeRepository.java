package projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.model.entity.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Integer> {
}

