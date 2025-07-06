package projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.model.entity.AreaConhecimento;

public interface AreaConhecimentoRepository extends JpaRepository<AreaConhecimento, Integer> {
}