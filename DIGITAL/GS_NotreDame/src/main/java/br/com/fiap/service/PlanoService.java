package br.com.fiap.service;

import br.com.fiap.entity.Beneficiario;
import br.com.fiap.entity.Plano;
import br.com.fiap.repository.PlanoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoService {
    @Autowired
    private PlanoRepository planoRepository;

    public Plano criarPlano(Plano plano) {
        return planoRepository.save(plano);
    }

    public List<Plano> procurarPlano() {
        return planoRepository.findAll();
    }

    public Plano buscarPlanoID(Long id) {
        return planoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plano não encontrado com o ID"));
    }
    @Transactional
    public Plano atualizarPlano(Long id, Plano newPlano) {
        Plano existingPlano = planoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plano não encontrado com o ID"));

        existingPlano.setData_contratacao(newPlano.getData_contratacao());
        return existingPlano;
    }

    public void deletarPlano(Long id) {
        planoRepository.deleteById(id);
    }
}
