package br.com.fiap.controllers.dto;

import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public class PlanoDTO {

    @NotNull
    private Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
