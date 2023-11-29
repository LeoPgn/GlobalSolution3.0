package br.com.fiap.services.Mapper;

import br.com.fiap.controllers.dto.ConsultaDTO;
import br.com.fiap.entities.Consulta;

public class ConsultaMapper {

    public static Consulta toEntity(ConsultaDTO consultaDTO) {
        Consulta consulta = new Consulta();
        consulta.setEspecialidade(consultaDTO.getEspecialidade());
        consulta.setData(consultaDTO.getData());
        return consulta;
    }

    public static ConsultaDTO toDTO(Consulta entity) {
        ConsultaDTO consultaDTO = new ConsultaDTO();
        consultaDTO.setEspecialidade(entity.getEspecialidade());
        consultaDTO.setData(entity.getData());
        return  consultaDTO;
    }
}
