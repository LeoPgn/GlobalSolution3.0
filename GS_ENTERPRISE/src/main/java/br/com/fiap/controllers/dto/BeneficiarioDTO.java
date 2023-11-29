package br.com.fiap.controllers.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public class BeneficiarioDTO {

    @NotNull
    private String nome;

    @NotNull
    private String email;

    @NotNull
    @Min(1)
    private String cpf;

    @NotNull
    private Date data_nascimento;

    @NotNull
    @Min(1)
    private Integer cep;

    @NotNull
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
