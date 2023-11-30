package br.com.fiap.controller;

import br.com.fiap.controller.dto.MedicoDTO;
import br.com.fiap.entity.Medico;
import br.com.fiap.service.MedicoService;
import br.com.fiap.service.mapper.MedicoMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
@Tag(name = "Medico", description = "CRUD do Medico")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTO> buscarMedico(@PathVariable Long id) {
        Medico medico = medicoService.buscarMedicoID(id);
        return ResponseEntity.ok(MedicoMapper.toDTO(medico));
    }

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> listarMedico() {
        List<MedicoDTO> listarMedico = medicoService.procurarMedico().stream().map(MedicoMapper::toDTO).toList();
        return ResponseEntity.ok(listarMedico);
    }

    @PostMapping
    public ResponseEntity<MedicoDTO> criarMedico(@Valid @RequestBody MedicoDTO medicoDTO) {
        Medico respostaMedico = medicoService.criarMedico(MedicoMapper.toEntity(medicoDTO));
        return ResponseEntity.ok(MedicoMapper.toDTO(respostaMedico));
    }


    @PutMapping("/{id}")
    public ResponseEntity<MedicoDTO> atualizarMedico(@PathVariable Long id, @Valid @RequestBody MedicoDTO medicoDTO) {
        Medico respostaMedico = medicoService.atualizarMedico(id, MedicoMapper.toEntity(medicoDTO));
        return ResponseEntity.ok(MedicoMapper.toDTO(respostaMedico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMedico(@PathVariable Long id) {
        medicoService.deletarMedico(id);
        return ResponseEntity.noContent().build();
    }

}
