package br.com.flowlife.controllers.dtos;

import jakarta.validation.constraints.NotNull;
import java.sql.Date;

public class ConsultaDTO {
    @NotNull
    private String especialidade;
    @NotNull
    private Date data_consulta;

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Date getData_consulta() {
        return data_consulta;
    }

    public void setData_consulta(Date data_consulta) {
        this.data_consulta = data_consulta;
    }
}
