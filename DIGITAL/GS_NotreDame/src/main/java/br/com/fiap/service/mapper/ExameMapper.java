package br.com.fiap.service.mapper;

import br.com.fiap.controller.dto.ExameDTO;
import br.com.fiap.entity.Exame;

public class ExameMapper {

    public static Exame toEntity (ExameDTO exameDTO) {
        Exame exame = new Exame();
        exame.setEspecialidade_exame(exameDTO.getEspecialidade_exame());
        exame.setData_exame(exameDTO.getData_exame());
        return exame;
    }
    public static ExameDTO toDTO (Exame exame) {
        ExameDTO exameDTO = new ExameDTO();
        exameDTO.setEspecialidade_exame(exame.getEspecialidade_exame());
        exameDTO.setData_exame(exame.getData_exame());
        return exameDTO;
    }
}
