package projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.model.entity.ParticipacaoAtividade;
import projeto.model.id.ParticipacaoAtividadeId;

public interface ParticipacaoAtividadeRepository extends JpaRepository<ParticipacaoAtividade, ParticipacaoAtividadeId> {
}
