package br.com.fiap.services;

import br.com.fiap.entities.Funcionario;
import br.com.fiap.repositories.FuncionarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario buscarFuncionarioID(Long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com o ID"));
    }

    public List<Funcionario> buscarFuncionario() {
        return funcionarioRepository.findAll();
    }

    public Funcionario criarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Transactional
    public Funcionario atualizarFuncionario(Long id, Funcionario funcionario) {
        Funcionario buscarFuncionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado com o ID"));

        buscarFuncionario.setNome(funcionario.getNome());
        buscarFuncionario.setCpf(funcionario.getCpf());
        buscarFuncionario.setData_nascimento(funcionario.getData_nascimento());
        buscarFuncionario.setCep(funcionario.getCep());

        return buscarFuncionario;
    }

    public void deletarFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
