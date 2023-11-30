package br.com.fiap.service.mapper;

import br.com.fiap.controller.dto.MedicoDTO;
import br.com.fiap.entity.Medico;

public class MedicoMapper {
    public static Medico toEntity (MedicoDTO medicoDTO) {
        Medico medico = new Medico();
        medico.setNome_medico(medicoDTO.getNome_medico());
        medico.setCpf_medico(medicoDTO.getCpf_medico());
        medico.setData_nascimento(medicoDTO.getData_nascimento());
        medico.setCep_medico(medicoDTO.getCep_medico());
        medico.setEspecialidade_medico(medicoDTO.getEspecialidade_medico());
        return medico;
    }
    public static MedicoDTO toDTO (Medico medico) {
        MedicoDTO medicoDTO = new MedicoDTO();
        medicoDTO.setNome_medico(medico.getNome_medico());
        medicoDTO.setCpf_medico(medico.getCpf_medico());
        medicoDTO.setData_nascimento(medico.getData_nascimento());
        medicoDTO.setCep_medico(medico.getCep_medico());
        medicoDTO.setEspecialidade_medico(medico.getEspecialidade_medico());
        return medicoDTO;
    }
}
