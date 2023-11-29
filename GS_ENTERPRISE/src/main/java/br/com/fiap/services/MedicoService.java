package br.com.fiap.services;

import br.com.fiap.entities.Medico;
import br.com.fiap.repositories.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico buscarMedicoID(Long id) {
        return medicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médico não encontrado com o ID"));
    }

    public List<Medico> buscarMedico() {
        return medicoRepository.findAll();
    }

    public Medico criarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Transactional
    public Medico atualizarMedico(Long id, Medico medico) {
        Medico buscarMedico = medicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médico não encontrado com o ID"));

        buscarMedico.setNome(medico.getNome());
        buscarMedico.setCpf(medico.getCpf());
        buscarMedico.setData_nascimento(medico.getData_nascimento());
        buscarMedico.setCep(medico.getCep());

        return buscarMedico;
    }

    public void deletarMedico(Long id) {
        medicoRepository.deleteById(id);
    }
}
