package projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.model.entity.JovemRequisitoEspecialidade;
import projeto.model.entity.Especialidade;
import projeto.repository.JovemRequisitoEspecialidadeRepository;
import projeto.repository.ERequisitoEspecialidadeRepository;

@Service
public class ProgressaoService {

    @Autowired
    private JovemRequisitoEspecialidadeRepository jovemRequisitoRepository;

    @Autowired
    private ERequisitoEspecialidadeRepository eRequisitoEspecialidadeRepository;

    /**
     * Calcula o nível atual de uma especialidade para um jovem
     * Nível 1: 1/3 dos requisitos
     * Nível 2: 2/3 dos requisitos  
     * Nível 3: todos os requisitos
     */
    public int calcularNivelEspecialidade(int idJovem, int idEspecialidade, int totalRequisitos) {
        // Contar quantos requisitos o jovem já cumpriu para esta especialidade
        long requisitosCumpridos = jovemRequisitoRepository.findAll().stream()
            .filter(jr -> jr.getIdJovem().getIdJovem() == idJovem)
            .filter(jr -> eRequisitoEspecialidadeRepository.findAll().stream()
                .anyMatch(ere -> ere.getIdRequisito().getIdRequisito() == jr.getIdRequisito().getIdRequisito() 
                    && ere.getIdEspecialidade().getIdEspecialidade() == idEspecialidade))
            .count();

        // Calcular nível baseado na proporção de requisitos cumpridos
        double proporcao = (double) requisitosCumpridos / totalRequisitos;
        
        if (proporcao >= 1.0) {
            return 3; // Nível 3 - todos os requisitos
        } else if (proporcao >= 2.0/3.0) {
            return 2; // Nível 2 - 2/3 dos requisitos
        } else if (proporcao >= 1.0/3.0) {
            return 1; // Nível 1 - 1/3 dos requisitos
        } else {
            return 0; // Ainda não atingiu nível 1
        }
    }

    /**
     * Verifica se um jovem pode obter uma especialidade em determinado nível
     */
    public boolean podeObterEspecialidade(int idJovem, int idEspecialidade, int nivelDesejado, int totalRequisitos) {
        int nivelAtual = calcularNivelEspecialidade(idJovem, idEspecialidade, totalRequisitos);
        return nivelAtual >= nivelDesejado;
    }
}