package br.com.fiap.service.mapper;

import br.com.fiap.controller.dto.PlanoDTO;
import br.com.fiap.entity.Plano;

public class PlanoMapper {
    public static Plano toEntity (PlanoDTO planoDTO) {
        Plano plano = new Plano();
        plano.setData_contratacao(planoDTO.getData_contratacao());
        return plano;
    }

    public static PlanoDTO toDTO (Plano plano) {
        PlanoDTO planoDTO = new PlanoDTO();
        planoDTO.setData_contratacao(plano.getData_contratacao());
        return planoDTO;
    }
}

