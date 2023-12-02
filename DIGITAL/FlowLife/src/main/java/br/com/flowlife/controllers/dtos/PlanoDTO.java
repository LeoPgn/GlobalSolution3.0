package br.com.flowlife.controllers.dtos;

import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public class PlanoDTO {
    @NotNull
    private Date data_contratacao;

    public Date getData_contratacao() {
        return data_contratacao;
    }

    public void setData_contratacao(Date data_contratacao) {
        this.data_contratacao = data_contratacao;
    }
}
