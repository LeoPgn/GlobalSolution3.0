package br.com.fiap.services;

import br.com.fiap.entities.Beneficiario;
import br.com.fiap.repositories.BeneficiarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiarioService {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    public Beneficiario buscarBeneficiarioID(Long id) {
        return beneficiarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Beneficiario não encontrado com o ID"));
    }

    public List<Beneficiario> buscarBeneficiario() {
        return beneficiarioRepository.findAll();
    }

    public Beneficiario criarBeneficiario(Beneficiario beneficiario) {
        return beneficiarioRepository.save(beneficiario);
    }

    @Transactional
    public Beneficiario atualizarBeneficiario(Long id, Beneficiario beneficiario) {
        Beneficiario buscarBeneficiario = beneficiarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Beneficiario não encontrado com o ID"));

        buscarBeneficiario.setNome(beneficiario.getNome());
        buscarBeneficiario.setEmail(beneficiario.getEmail());
        buscarBeneficiario.setCpf(beneficiario.getCpf());
        buscarBeneficiario.setData_nascimento(beneficiario.getData_nascimento());
        buscarBeneficiario.setCep(beneficiario.getCep());
        buscarBeneficiario.setSenha(beneficiario.getSenha());

        return buscarBeneficiario;
    }

    public void deletarBeneficiario(Long id) {
        beneficiarioRepository.deleteById(id);
    }
}
