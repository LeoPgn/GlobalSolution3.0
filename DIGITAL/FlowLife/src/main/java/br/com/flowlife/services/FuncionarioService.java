package br.com.flowlife.services;

import br.com.flowlife.entities.Funcionario;
import br.com.flowlife.repositories.FuncionarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario buscarFuncionarioID(Long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado com o ID"));
    }

    public List<Funcionario> procurarFuncionario() {
        return funcionarioRepository.findAll();
    }

    public Page<Funcionario> procurarFuncionarioPage(Pageable pageable) {
        return funcionarioRepository.findAll(pageable);
    }
    public Funcionario criarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Transactional
    public Funcionario atualizarFuncionario(Long id, Funcionario newFuncionario) {
        Funcionario existingFuncionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado com o ID"));

        existingFuncionario.setNome(newFuncionario.getNome());
        existingFuncionario.setCpf(newFuncionario.getCpf());
        existingFuncionario.setData(newFuncionario.getData());
        existingFuncionario.setCep(newFuncionario.getCep());
        return existingFuncionario;
    }

    public void deletarFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }

}
