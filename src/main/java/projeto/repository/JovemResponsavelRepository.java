package projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.model.entity.JovemResponsavel;
import projeto.model.id.JovemResponsavelId;

public interface JovemResponsavelRepository extends JpaRepository<JovemResponsavel, JovemResponsavelId> {
}

