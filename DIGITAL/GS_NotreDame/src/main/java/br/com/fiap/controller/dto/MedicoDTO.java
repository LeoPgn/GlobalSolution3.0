package br.com.fiap.controller.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.sql.Date;

public class MedicoDTO {
    @NotNull
    private String nome_medico;
    @NotNull
    @Min(1)
    @Max(11)
    private String cpf_medico;
    @NotNull
    private Date data_nascimento;
    @NotNull
    @Min(1)
    @Max(8)
    private Integer cep_medico;
    @NotNull
    private String especialidade_medico;

    public String getNome_medico() {
        return nome_medico;
    }

    public void setNome_medico(String nome_medico) {
        this.nome_medico = nome_medico;
    }

    public String getCpf_medico() {
        return cpf_medico;
    }

    public void setCpf_medico(String cpf_medico) {
        this.cpf_medico = cpf_medico;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Integer getCep_medico() {
        return cep_medico;
    }

    public void setCep_medico(Integer cep_medico) {
        this.cep_medico = cep_medico;
    }

    public String getEspecialidade_medico() {
        return especialidade_medico;
    }

    public void setEspecialidade_medico(String especialidade_medico) {
        this.especialidade_medico = especialidade_medico;
    }
}
