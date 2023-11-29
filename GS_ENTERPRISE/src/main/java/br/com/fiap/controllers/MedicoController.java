package br.com.fiap.controllers;

import br.com.fiap.controllers.dto.MedicoDTO;
import br.com.fiap.entities.Medico;
import br.com.fiap.services.Mapper.MedicoMapper;
import br.com.fiap.services.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTO> buscarMedico(@PathVariable Long id) {
        Medico medico = medicoService.buscarMedicoID(id);
        return ResponseEntity.ok(MedicoMapper.toDTO(medico));
    }

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> listMedico() {
        List<MedicoDTO> listarMedico = medicoService.buscarMedico().stream().map(MedicoMapper::toDTO).toList();
        return ResponseEntity.ok(listarMedico);
    }

    @PostMapping
    public ResponseEntity<MedicoDTO> criarMedico(@Valid @RequestBody MedicoDTO medicoDTO) {
        Medico respostaMedico = medicoService.criarMedico(MedicoMapper.toEntity(medicoDTO));
        return ResponseEntity.ok(MedicoMapper.toDTO(respostaMedico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoDTO> updateMedico(@PathVariable Long id, @Valid @RequestBody MedicoDTO medicoDTO) {
        Medico respostaMedico = medicoService.atualizarMedico(id, MedicoMapper.toEntity(medicoDTO));
        return ResponseEntity.ok(MedicoMapper.toDTO(respostaMedico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMedico(@PathVariable Long id) {
        medicoService.deletarMedico(id);
        return ResponseEntity.noContent().build();
    }
}
