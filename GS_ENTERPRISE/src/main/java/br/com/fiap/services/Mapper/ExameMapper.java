package br.com.fiap.services.Mapper;

import br.com.fiap.controllers.dto.ExameDTO;
import br.com.fiap.entities.Exame;

public class ExameMapper {

    public static Exame toEntity(ExameDTO exameDTO) {
        Exame exame = new Exame();
        exame.setEspecialidade(exameDTO.getEspecialidade());
        exame.setData(exameDTO.getData());
        return exame;
    }

    public static ExameDTO toDTO(Exame entity) {
        ExameDTO exameDTO = new ExameDTO();
        exameDTO.setEspecialidade(entity.getEspecialidade());
        exameDTO.setData(entity.getData());
        return  exameDTO;
    }
}
