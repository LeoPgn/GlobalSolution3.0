package br.com.fiap.controllers;

import br.com.fiap.controllers.dto.ExameDTO;
import br.com.fiap.entities.Exame;
import br.com.fiap.services.ExameService;
import br.com.fiap.services.Mapper.ExameMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exame")
public class ExameController {

    @Autowired
    private ExameService exameService;

    @GetMapping("/{id}")
    public ResponseEntity<ExameDTO> buscarExame(@PathVariable Long id) {
        Exame exame = exameService.buscarExameID(id);
        return ResponseEntity.ok(ExameMapper.toDTO(exame));
    }

    @GetMapping
    public ResponseEntity<List<ExameDTO>> listExame() {
        List<ExameDTO> listarExame = exameService.buscarExame().stream().map(ExameMapper::toDTO).toList();
        return ResponseEntity.ok(listarExame);
    }

    @PostMapping
    public ResponseEntity<ExameDTO> criarExame(@Valid @RequestBody ExameDTO exameDTO) {
        Exame respostaExame = exameService.criarExame(ExameMapper.toEntity(exameDTO));
        return ResponseEntity.ok(ExameMapper.toDTO(respostaExame));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExameDTO> updateExame(@PathVariable Long id, @Valid @RequestBody ExameDTO exameDTO) {
        Exame respostaExame = exameService.atualizarExame(id, ExameMapper.toEntity(exameDTO));
        return ResponseEntity.ok(ExameMapper.toDTO(respostaExame));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarExame(@PathVariable Long id) {
        exameService.deletarExame(id);
        return ResponseEntity.noContent().build();
    }
}
