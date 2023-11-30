package br.com.fiap.controller;

import br.com.fiap.controller.dto.ConsultaDTO;
import br.com.fiap.entity.Consulta;
import br.com.fiap.service.ConsultaService;
import br.com.fiap.service.mapper.ConsultaMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
@Tag(name = "Consulta", description = "CRUD da Consulta")
public class ConsultaController {

        @Autowired
        private ConsultaService consultaService;

        @GetMapping("/{id}")
        public ResponseEntity<ConsultaDTO> buscarConsulta(@PathVariable Long id) {
        Consulta consulta = consultaService.buscarConsultaID(id);
        return ResponseEntity.ok(ConsultaMapper.toDTO(consulta));
        }

        @GetMapping
        public ResponseEntity<List<ConsultaDTO>> listarConsulta() {
        List<ConsultaDTO> listarConsulta = consultaService.procurarConsulta().stream().map(ConsultaMapper::toDTO).toList();
        return ResponseEntity.ok(listarConsulta);
        }

        @PostMapping
        public ResponseEntity<ConsultaDTO> criarConsulta(@Valid @RequestBody ConsultaDTO consultaDTO) {
            Consulta respostaConsulta = consultaService.criarConsulta(ConsultaMapper.toEntity(consultaDTO));
            return ResponseEntity.ok(ConsultaMapper.toDTO(respostaConsulta));
        }


        @PutMapping("/{id}")
        public ResponseEntity<ConsultaDTO> atualizarConsulta(@PathVariable Long id, @Valid @RequestBody ConsultaDTO consultaDTO) {
            Consulta respostaConsulta = consultaService.atualizarConsulta(id, ConsultaMapper.toEntity(consultaDTO));
            return ResponseEntity.ok(ConsultaMapper.toDTO(respostaConsulta));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletarConsulta(@PathVariable Long id) {
            consultaService.deletarConsulta(id);
            return ResponseEntity.noContent().build();
        }

}
