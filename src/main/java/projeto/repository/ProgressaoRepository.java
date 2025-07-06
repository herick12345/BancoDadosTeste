package projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.model.entity.Progressao;

public interface ProgressaoRepository extends JpaRepository<Progressao, Integer> {
}
