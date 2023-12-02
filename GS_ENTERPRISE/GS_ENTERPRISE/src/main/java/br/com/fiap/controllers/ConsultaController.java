package br.com.fiap.controllers;

import br.com.fiap.controllers.dto.ConsultaDTO;
import br.com.fiap.entities.Consulta;
import br.com.fiap.services.ConsultaService;
import br.com.fiap.services.Mapper.ConsultaMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDTO> buscarConsulta(@PathVariable Long id) {
        Consulta consulta = consultaService.buscarConsultaID(id);
        return ResponseEntity.ok(ConsultaMapper.toDTO(consulta));
    }

    @GetMapping
    public ResponseEntity<List<ConsultaDTO>> listConsulta() {
        List<ConsultaDTO> listarConsulta = consultaService.buscarConsulta().stream().map(ConsultaMapper::toDTO).toList();
        return ResponseEntity.ok(listarConsulta);
    }

    @PostMapping
    public ResponseEntity<ConsultaDTO> criarConsulta(@Valid @RequestBody ConsultaDTO consultaDTO) {
        Consulta respostaConsulta = consultaService.criarConsulta(ConsultaMapper.toEntity(consultaDTO));
        return ResponseEntity.ok(ConsultaMapper.toDTO(respostaConsulta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaDTO> updateConsulta(@PathVariable Long id, @Valid @RequestBody ConsultaDTO consultaDTO) {
        Consulta respostaConsulta = consultaService.atualizarDepartment(id, ConsultaMapper.toEntity(consultaDTO));
        return ResponseEntity.ok(ConsultaMapper.toDTO(respostaConsulta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConsulta(@PathVariable Long id) {
        consultaService.deletarConsulta(id);
        return ResponseEntity.noContent().build();
    }

}
