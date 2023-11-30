package br.com.fiap.service;

import br.com.fiap.entity.Exame;
import br.com.fiap.repository.ExameRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExameService {
    @Autowired
    private ExameRepository exameRepository;

    public Exame criarExame(Exame exame) {
        return exameRepository.save(exame);
    }

    public List<Exame> procurarExame() {
        return exameRepository.findAll();
    }

    public Exame buscarExameID(Long id) {
        return exameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exame não encontrado com o ID"));
    }
    @Transactional
    public Exame atualizarExame(Long id, Exame newExame) {
        Exame existingExame = exameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exame não encontrado com o ID"));

        existingExame.setEspecialidade_exame(newExame.getEspecialidade_exame());
        existingExame.setData_exame(newExame.getData_exame());

        return existingExame;
    }

    public void deletarExame(Long id) {
        exameRepository.deleteById(id);
    }
}
