package br.com.fiap.controller;

import br.com.fiap.controller.dto.PlanoDTO;
import br.com.fiap.entity.Plano;
import br.com.fiap.service.PlanoService;
import br.com.fiap.service.mapper.PlanoMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PlanoController {
    @Autowired
    private PlanoService planoService;

    @GetMapping("/{id}")
    public ResponseEntity<PlanoDTO> buscarPlano(@PathVariable Long id) {
        Plano plano = planoService.buscarPlanoID(id);
        return ResponseEntity.ok(PlanoMapper.toDTO(plano));
    }

    @GetMapping
    public ResponseEntity<List<PlanoDTO>> listarPlano() {
        List<PlanoDTO> listarPlano = planoService.procurarPlano().stream().map(PlanoMapper::toDTO).toList();
        return ResponseEntity.ok(listarPlano);
    }

    @PostMapping
    public ResponseEntity<PlanoDTO> criarPlano(@Valid @RequestBody PlanoDTO planoDTO) {
        Plano respostaPlano = planoService.criarPlano(PlanoMapper.toEntity(planoDTO));
        return ResponseEntity.ok(PlanoMapper.toDTO(respostaPlano));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanoDTO> atualizarPlano(@PathVariable Long id, @Valid @RequestBody PlanoDTO planoDTO) {
        Plano respostaPlano = planoService.atualizarPlano(id, PlanoMapper.toEntity(planoDTO));
        return ResponseEntity.ok(PlanoMapper.toDTO(respostaPlano));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPlano(@PathVariable Long id) {
        planoService.deletarPlano(id);
        return ResponseEntity.noContent().build();
    }
}
