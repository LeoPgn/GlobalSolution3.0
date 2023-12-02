package br.com.flowlife.services;

import br.com.flowlife.entities.Exame;
import br.com.flowlife.repositories.ExameRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ExameService {
    @Autowired
    private ExameRepository exameRepository;

    public Exame buscarExameID(Long id) {
        return exameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exame não encontrado com o ID"));
    }

    public List<Exame> procurarExame() {
        return exameRepository.findAll();
    }

    public Page<Exame> procurarExamePage(Pageable pageable) {
        return exameRepository.findAll(pageable);
    }

    public Exame criarExame(Exame exame) {
        return exameRepository.save(exame);
    }

    @Transactional
    public Exame atualizarExame(Long id, Exame newExame) {
        Exame existingExame = exameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exame não encontrado com o ID"));

        existingExame.setEspecialidade(newExame.getEspecialidade());
        existingExame.setData(newExame.getData());

        return existingExame;
    }

    public void deletarExame(Long id) {
        exameRepository.deleteById(id);
    }

}
