package ads.bcd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ads.bcd.model.Especialidade;
import ads.bcd.repository.EspecialidadeRepository;

@Service
public class EspecialidadeService {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    public List<Especialidade> listarTodas() {
        return (List<Especialidade>) especialidadeRepository.findAll();
    }

    public Optional<Especialidade> buscarPorId(Integer id) {
        return especialidadeRepository.findById(id);
    }

    public Especialidade salvar(Especialidade especialidade) {
        return especialidadeRepository.save(especialidade);
    }

    public void deletar(Integer id) {
        especialidadeRepository.deleteById(id);
    }

    public List<Especialidade> buscarPorNivel(Integer nivel) {
        return especialidadeRepository.findByNivel(nivel);
    }
}