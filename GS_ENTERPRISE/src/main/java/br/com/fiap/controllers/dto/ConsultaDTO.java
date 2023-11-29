package br.com.fiap.controllers.dto;

import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public class ConsultaDTO {

    @NotNull
    private String especialidade;
    @NotNull
    private Date data;

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
