package br.com.flowlife.services;

import br.com.flowlife.entities.Medico;
import br.com.flowlife.repositories.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    public Medico buscarMedicoID(Long id) {
        return medicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medico não encontrado com o ID"));
    }

    public List<Medico> procurarMedico() {
        return medicoRepository.findAll();
    }

    public Page<Medico> procurarMedicoPage(Pageable pageable) {
        return medicoRepository.findAll(pageable);
    }

    public Medico criarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Transactional
    public Medico atualizarMedico(Long id, Medico newMedico) {
        Medico existingMedico = medicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medico não encontrado com o ID"));

        existingMedico.setNome(newMedico.getNome());
        existingMedico.setCpf(newMedico.getCpf());
        existingMedico.setData(newMedico.getData());
        existingMedico.setCep(newMedico.getCep());
        existingMedico.setEspecialidade(newMedico.getEspecialidade());
        return existingMedico;
    }

    public void deletarMedico(Long id) {
        medicoRepository.deleteById(id);
    }
}
