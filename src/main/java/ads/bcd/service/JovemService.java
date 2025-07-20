package ads.bcd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ads.bcd.model.Jovem;
import ads.bcd.repository.JovemRepository;

@Service
public class JovemService {

    private final JovemRepository jovemRepository;

    public JovemService(JovemRepository jovemRepository) {
        this.jovemRepository = jovemRepository;
    }

    public List<Jovem> listarTodos() {
        return (List<Jovem>) jovemRepository.findAll();
    }

    public Optional<Jovem> buscarPorId(Integer id) {
        return jovemRepository.findById(id);
    }

    public Jovem salvar(Jovem jovem) {
        return jovemRepository.save(jovem);
    }

    public void deletar(Integer id) {
        jovemRepository.deleteById(id);
    }

    public List<Jovem> buscarPorNome(String nome) {
        return jovemRepository.findByNome(nome);
    }

    public List<Jovem> buscarPorTipoSanguineo(String tipoSanguineo) {
        return jovemRepository.findByTipoSanguineo(tipoSanguineo);
    }
}