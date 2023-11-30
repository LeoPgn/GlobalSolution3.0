package br.com.fiap.controller.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.sql.Date;

public class FuncionarioDTO {
    @NotNull
    private String nome;
    @NotNull
    @Min(1)
    @Max(11)
    private String cpf_funcionario;
    @NotNull
    private Date data_nascimento;
    @NotNull
    @Min(1)
    @Max(8)
    private Integer cep_funcionario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf_funcionario() {
        return cpf_funcionario;
    }

    public void setCpf_funcionario(String cpf_funcionario) {
        this.cpf_funcionario = cpf_funcionario;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Integer getCep_funcionario() {
        return cep_funcionario;
    }

    public void setCep_funcionario(Integer cep_funcionario) {
        this.cep_funcionario = cep_funcionario;
    }
}
