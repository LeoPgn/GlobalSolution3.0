package br.com.fiap.service.mapper;

import br.com.fiap.controller.dto.FuncionarioDTO;
import br.com.fiap.entity.Funcionario;

public class FuncionarioMapper {
    public static Funcionario toEntity (FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setCpf_funcionario(funcionarioDTO.getCpf_funcionario());
        funcionario.setData_nascimento(funcionarioDTO.getData_nascimento());
        funcionario.setCep_funcionario(funcionarioDTO.getCep_funcionario());
        return funcionario;
    }

    public static FuncionarioDTO toDTO (Funcionario funcionario){
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        funcionarioDTO.setNome(funcionario.getNome());
        funcionarioDTO.setCpf_funcionario(funcionario.getCpf_funcionario());
        funcionarioDTO.setData_nascimento(funcionario.getData_nascimento());
        funcionarioDTO.setCep_funcionario(funcionario.getCep_funcionario());
        return funcionarioDTO;
    }
}
