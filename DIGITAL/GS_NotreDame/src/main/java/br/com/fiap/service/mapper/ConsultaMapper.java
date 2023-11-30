package br.com.fiap.service.mapper;

import br.com.fiap.controller.dto.ConsultaDTO;
import br.com.fiap.entity.Consulta;

public class ConsultaMapper {

    public static Consulta toEntity (ConsultaDTO consultaDTO){
        Consulta consulta = new Consulta();
        consulta.setEspecialidade(consultaDTO.getEspecialidade());
        consulta.setData_consulta(consultaDTO.getData_consulta());
        return consulta;
    }
    public static ConsultaDTO toDTO (Consulta consulta) {
        ConsultaDTO consultaDTO = new ConsultaDTO();
        consultaDTO.setEspecialidade(consulta.getEspecialidade());
        consultaDTO.setData_consulta(consulta.getData_consulta());
        return consultaDTO;
    }
}
