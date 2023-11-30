package br.com.fiap.service;

import br.com.fiap.entity.Beneficiario;
import br.com.fiap.entity.Medico;
import br.com.fiap.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    public Medico criarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    public List<Medico> procurarMedico() {
        return medicoRepository.findAll();
    }

    public Medico buscarMedicoID(Long id) {
        return medicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medico não encontrado com o ID"));
    }
    @Transactional
    public Medico atualizarMedico(Long id, Medico newMedico) {
        Medico existingMedico = medicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medico não encontrado com o ID"));

        existingMedico.setNome_medico(newMedico.getNome_medico());
        existingMedico.setCpf_medico(newMedico.getCpf_medico());
        existingMedico.setData_nascimento(newMedico.getData_nascimento());
        existingMedico.setCep_medico(newMedico.getCep_medico());
        existingMedico.setEspecialidade_medico(newMedico.getEspecialidade_medico());
        return existingMedico;
    }

    public void deletarMedico(Long id) {
        medicoRepository.deleteById(id);
    }
}
