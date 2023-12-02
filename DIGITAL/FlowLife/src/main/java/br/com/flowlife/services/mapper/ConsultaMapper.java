package br.com.flowlife.services.mapper;

import br.com.flowlife.controllers.dtos.ConsultaDTO;
import br.com.flowlife.entities.Consulta;

public class ConsultaMapper {

    public static Consulta toEntity(ConsultaDTO consultaDTO){
        Consulta consulta = new Consulta();
        consulta.setEspecialidade(consultaDTO.getEspecialidade());
        consulta.setData(consultaDTO.getData_consulta());
        return consulta;
    }
    public static ConsultaDTO toDTO(Consulta consulta) {
        ConsultaDTO consultaDTO = new ConsultaDTO();
        consultaDTO.setEspecialidade(consulta.getEspecialidade());
        consultaDTO.setData_consulta(consulta.getData());
        return consultaDTO;
    }
}