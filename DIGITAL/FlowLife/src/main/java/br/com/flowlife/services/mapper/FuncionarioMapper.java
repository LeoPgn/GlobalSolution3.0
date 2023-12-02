package br.com.flowlife.services.mapper;

import br.com.flowlife.controllers.dtos.FuncionarioDTO;
import br.com.flowlife.entities.Funcionario;

public class FuncionarioMapper {
    public static Funcionario toEntity(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setCpf(funcionarioDTO.getCpf());
        funcionario.setData(funcionarioDTO.getData_nascimento());
        funcionario.setCep(funcionarioDTO.getCep());
        return funcionario;
    }

    public static FuncionarioDTO toDTO(Funcionario funcionario){
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        funcionarioDTO.setNome(funcionario.getNome());
        funcionarioDTO.setCpf(funcionario.getCpf());
        funcionarioDTO.setData_nascimento(funcionario.getData());
        funcionarioDTO.setCep(funcionario.getCep());
        return funcionarioDTO;
    }
}