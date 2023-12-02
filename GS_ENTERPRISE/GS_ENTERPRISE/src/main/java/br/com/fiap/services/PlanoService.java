package br.com.fiap.services;

import br.com.fiap.entities.Plano;
import br.com.fiap.repositories.PlanoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    public Plano buscarPlanotID(Long id) {
        return planoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plano não encontrado com o ID"));
    }

    public List<Plano> buscarPlano() {
        return planoRepository.findAll();
    }

    public Plano criarPlano(Plano plano) {
        return planoRepository.save(plano);
    }

    @Transactional
    public Plano atualizarPlano(Long id, Plano plano) {
        Plano buscaPlano = planoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plano não encontrado com o ID"));

        buscaPlano.setData(plano.getData());

        return buscaPlano;
    }

    public void deletarPlano(Long id) {
        planoRepository.deleteById(id);
    }
}
