package br.com.flowlife.services.mapper;

import br.com.flowlife.controllers.dtos.ExameDTO;
import br.com.flowlife.entities.Exame;

public class ExameMapper {

    public static Exame toEntity(ExameDTO exameDTO) {
        Exame exame = new Exame();
        exame.setEspecialidade(exameDTO.getEspecialidade_exame());
        exame.setData(exameDTO.getData_exame());
        return exame;
    }
    public static ExameDTO toDTO(Exame exame) {
        ExameDTO exameDTO = new ExameDTO();
        exameDTO.setEspecialidade_exame(exame.getEspecialidade());
        exameDTO.setData_exame(exame.getData());
        return exameDTO;
    }
}