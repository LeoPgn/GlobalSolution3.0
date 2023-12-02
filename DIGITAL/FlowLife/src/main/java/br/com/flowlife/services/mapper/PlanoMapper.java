package br.com.flowlife.services.mapper;

import br.com.flowlife.controllers.dtos.PlanoDTO;
import br.com.flowlife.entities.Plano;

public class PlanoMapper {
    public static Plano toEntity(PlanoDTO planoDTO) {
        Plano plano = new Plano();
        plano.setData(planoDTO.getData_contratacao());
        return plano;
    }

    public static PlanoDTO toDTO(Plano plano) {
        PlanoDTO planoDTO = new PlanoDTO();
        planoDTO.setData_contratacao(plano.getData());
        return planoDTO;
    }
}