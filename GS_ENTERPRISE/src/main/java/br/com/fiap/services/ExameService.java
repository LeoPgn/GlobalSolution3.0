package br.com.fiap.services;

import br.com.fiap.entities.Exame;
import br.com.fiap.repositories.ExameRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExameService {

    @Autowired
    private ExameRepository exameRepository;

    public Exame buscarExameID(Long id) {
        return exameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exame não encontrado com o ID"));
    }

    public List<Exame> buscarExame() {
        return exameRepository.findAll();
    }

    public Exame criarExame(Exame exame) {
        return exameRepository.save(exame);
    }

    @Transactional
    public Exame atualizarExame(Long id, Exame exame) {
        Exame buscarExame = exameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exame não encontrado com o ID"));

        buscarExame.setEspecialidade(exame.getEspecialidade());
        buscarExame.setData(exame.getData());

        return buscarExame;
    }

    public void deletarExame(Long id) {
        exameRepository.deleteById(id);
    }
}
