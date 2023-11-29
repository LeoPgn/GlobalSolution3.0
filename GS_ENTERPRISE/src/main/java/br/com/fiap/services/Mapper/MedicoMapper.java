package br.com.fiap.services.Mapper;


import br.com.fiap.controllers.dto.MedicoDTO;
import br.com.fiap.entities.Medico;

public class MedicoMapper {

    public static Medico toEntity(MedicoDTO medicoDTO) {
        Medico medico = new Medico();
        medico.setNome(medicoDTO.getNome());
        medico.setCpf(medicoDTO.getCpf());
        medico.setData_nascimento(medicoDTO.getData_nascimento());
        medico.setCep(medicoDTO.getCep());
        medico.setEspecialidade(medicoDTO.getEspecialidade());
        return medico;
    }

    public static MedicoDTO toDTO(Medico entity) {
        MedicoDTO medicoDTO = new MedicoDTO();
        medicoDTO.setNome(entity.getNome());
        medicoDTO.setCpf(entity.getCpf());
        medicoDTO.setData_nascimento(entity.getData_nascimento());
        medicoDTO.setCep(entity.getCep());
        medicoDTO.setEspecialidade(entity.getEspecialidade());
        return  medicoDTO;
    }
}
