package br.com.fiap.controller.dto;

import jakarta.validation.constraints.NotNull;
import java.sql.Date;

public class ExameDTO {
   @NotNull
    private String especialidade_exame;
  @NotNull
    private Date data_exame;

    public String getEspecialidade_exame() {
        return especialidade_exame;
    }

    public void setEspecialidade_exame(String especialidade_exame) {
        this.especialidade_exame = especialidade_exame;
    }

    public Date getData_exame() {
        return data_exame;
    }

    public void setData_exame(Date data_exame) {
        this.data_exame = data_exame;
    }
}
