package br.com.flowlife.controllers;

import br.com.flowlife.controllers.dtos.PlanoDTO;
import br.com.flowlife.entities.Plano;
import br.com.flowlife.services.PlanoService;
import br.com.flowlife.services.mapper.PlanoMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plano")
@Tag(name = "Plano", description = "CRUD do Plano")
public class PlanoController {
    @Autowired
    private PlanoService planoService;

    @GetMapping("/{id}")
    public ResponseEntity<PlanoDTO> buscarPlano(@Valid @PathVariable Long id) {
        Plano plano = planoService.buscarPlanoID(id);
        return ResponseEntity.ok(PlanoMapper.toDTO(plano));
    }

    @GetMapping
    public ResponseEntity<List<PlanoDTO>> listarPlano() {
        List<PlanoDTO> listarPlano = planoService.procurarPlano().stream().map(PlanoMapper::toDTO).toList();
        return ResponseEntity.ok(listarPlano);
    }

    @GetMapping("/page")
    public ResponseEntity<List<PlanoDTO>> listarPlanoPage(Pageable pageable) {
        List<PlanoDTO> listarPlano = planoService.procurarPlanoPage(pageable).stream().map(PlanoMapper::toDTO).toList();
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
