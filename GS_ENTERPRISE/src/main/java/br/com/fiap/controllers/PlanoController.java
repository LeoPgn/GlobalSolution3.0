package br.com.fiap.controllers;

import br.com.fiap.controllers.dto.PlanoDTO;
import br.com.fiap.entities.Plano;
import br.com.fiap.services.Mapper.PlanoMapper;
import br.com.fiap.services.PlanoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plano")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @GetMapping("/{id}")
    public ResponseEntity<PlanoDTO> buscarPlano(@PathVariable Long id) {
        Plano plano = planoService.buscarPlanotID(id);
        return ResponseEntity.ok(PlanoMapper.toDTO(plano));
    }

    @GetMapping
    public ResponseEntity<List<PlanoDTO>> listPlano() {
        List<PlanoDTO> listarPlano = planoService.buscarPlano().stream().map(PlanoMapper::toDTO).toList();
        return ResponseEntity.ok(listarPlano);
    }

    @PostMapping
    public ResponseEntity<PlanoDTO> criarPlano(@Valid @RequestBody PlanoDTO planoDTO) {
        Plano respostaPlano = planoService.criarPlano(PlanoMapper.toEntity(planoDTO));
        return ResponseEntity.ok(PlanoMapper.toDTO(respostaPlano));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanoDTO> updatePlano(@PathVariable Long id, @Valid @RequestBody PlanoDTO planoDTO) {
        Plano respostaPlano = planoService.atualizarPlano(id, PlanoMapper.toEntity(planoDTO));
        return ResponseEntity.ok(PlanoMapper.toDTO(respostaPlano));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPlano(@PathVariable Long id) {
        planoService.deletarPlano(id);
        return ResponseEntity.noContent().build();
    }
}
