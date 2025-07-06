package projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.model.entity.Jovem;

public interface JovemRepository extends JpaRepository<Jovem, Integer> {

}
