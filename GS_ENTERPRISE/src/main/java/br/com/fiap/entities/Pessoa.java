package br.com.fiap.entities;

import jakarta.persistence.MappedSuperclass;

import java.sql.Date;

@MappedSuperclass
public abstract class Pessoa {

    private String nome;
    private String cpf;
    private Date data_nascimento;
    private Integer cep;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
}
