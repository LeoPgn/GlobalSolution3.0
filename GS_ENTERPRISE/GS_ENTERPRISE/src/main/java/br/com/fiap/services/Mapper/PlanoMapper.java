package br.com.fiap.services.Mapper;

import br.com.fiap.controllers.dto.PlanoDTO;
import br.com.fiap.entities.Plano;

public class PlanoMapper {

    public static Plano toEntity(PlanoDTO planoDTO) {
        Plano plano = new Plano();
        plano.setData(planoDTO.getData());
        return plano;
    }

    public static PlanoDTO toDTO(Plano entity) {
        PlanoDTO planoDTO = new PlanoDTO();
        planoDTO.setData(entity.getData());
        return  planoDTO;
    }
}
