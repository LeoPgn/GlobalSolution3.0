package br.com.flowlife.controllers.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.sql.Date;

public class MedicoDTO {
    @NotNull
    private String nome;
    @NotNull
    @Min(1)
    private String cpf;
    @NotNull
    private Date data;
    @NotNull
    @Min(1)
    private Integer cep;
    @NotNull
    private String especialidade_medico;

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getEspecialidade_medico() {
        return especialidade_medico;
    }

    public void setEspecialidade_medico(String especialidade_medico) {
        this.especialidade_medico = especialidade_medico;
    }
}
