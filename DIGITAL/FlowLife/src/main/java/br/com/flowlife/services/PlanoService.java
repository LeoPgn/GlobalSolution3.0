package br.com.flowlife.services;

import br.com.flowlife.entities.Plano;
import br.com.flowlife.repositories.PlanoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class PlanoService {
    @Autowired
    private PlanoRepository planoRepository;

    public Plano buscarPlanoID(Long id) {
        return planoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plano não encontrado com o ID"));
    }

    public List<Plano> procurarPlano() {
        return planoRepository.findAll();
    }

    public Page<Plano> procurarPlanoPage(Pageable pageable) {
        return planoRepository.findAll(pageable);
    }

    public Plano criarPlano(Plano plano) {
        return planoRepository.save(plano);
    }

    @Transactional
    public Plano atualizarPlano(Long id, Plano newPlano) {
        Plano existingPlano = planoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plano não encontrado com o ID"));

        existingPlano.setData(newPlano.getData());
        return existingPlano;
    }

    public void deletarPlano(Long id) {
        planoRepository.deleteById(id);
    }

}
