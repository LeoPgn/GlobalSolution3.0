package br.com.fiap.service;

import br.com.fiap.entity.Beneficiario;
import br.com.fiap.entity.Funcionario;
import br.com.fiap.repository.FuncionarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    public Funcionario criarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> procurarFuncionario() {
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarFuncionarioID(Long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado com o ID"));
    }
    @Transactional
    public Funcionario atualizarFuncionario(Long id, Funcionario newFuncionario) {
        Funcionario existingFuncionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado com o ID"));

        existingFuncionario.setNome(newFuncionario.getNome());
        existingFuncionario.setCpf_funcionario(newFuncionario.getCpf_funcionario());
        existingFuncionario.setData_nascimento(newFuncionario.getData_nascimento());
        existingFuncionario.setCep_funcionario(newFuncionario.getCep_funcionario());
        return existingFuncionario;
    }

    public void deletarFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
