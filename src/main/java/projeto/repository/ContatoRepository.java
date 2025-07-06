package projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.model.entity.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {
}
