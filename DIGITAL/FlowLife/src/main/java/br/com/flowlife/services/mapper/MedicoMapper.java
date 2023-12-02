package br.com.flowlife.services.mapper;

import br.com.flowlife.controllers.dtos.MedicoDTO;
import br.com.flowlife.entities.Medico;

public class MedicoMapper {
    public static Medico toEntity(MedicoDTO medicoDTO) {
        Medico medico = new Medico();
        medico.setNome(medicoDTO.getNome());
        medico.setCpf(medicoDTO.getCpf());
        medico.setData(medicoDTO.getData());
        medico.setCep(medicoDTO.getCep());
        medico.setEspecialidade(medicoDTO.getEspecialidade_medico());
        return medico;
    }
    public static MedicoDTO toDTO(Medico medico) {
        MedicoDTO medicoDTO = new MedicoDTO();
        medicoDTO.setNome(medico.getNome());
        medicoDTO.setCpf(medico.getCpf());
        medicoDTO.setData(medico.getData());
        medicoDTO.setCep(medico.getCep());
        medicoDTO.setEspecialidade_medico(medico.getEspecialidade());
        return medicoDTO;
    }
}