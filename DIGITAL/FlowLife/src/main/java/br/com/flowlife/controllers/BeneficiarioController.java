package br.com.flowlife.controllers;

import br.com.flowlife.controllers.dtos.BeneficiarioDTO;
import br.com.flowlife.entities.Beneficiario;
import br.com.flowlife.services.BeneficiarioService;
import br.com.flowlife.services.mapper.BeneficiarioMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beneficiario")
@Tag(name = "Beneficiario", description = "CRUD do Beneficiario")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioService beneficiarioService;

    @GetMapping("/{id}")
    public ResponseEntity<BeneficiarioDTO> buscarBeneficiario(@Valid @PathVariable Long id) {
        Beneficiario beneficiario = beneficiarioService.buscarBeneficiarioID(id);
        return ResponseEntity.ok(BeneficiarioMapper.toDTO(beneficiario));
    }

    @GetMapping
    public ResponseEntity<List<BeneficiarioDTO>> listarBeneficiario() {
        List<BeneficiarioDTO> listarBeneficiario = beneficiarioService.procurarBeneficiario().stream().map(BeneficiarioMapper::toDTO).toList();
        return ResponseEntity.ok(listarBeneficiario);
    }

    @GetMapping("/page")
    public ResponseEntity<List<BeneficiarioDTO>> listarBeneficiarioPage(Pageable pageable) {
        List<BeneficiarioDTO> listarBeneficiario = beneficiarioService.procurarBeneficiarioPage(pageable).stream().map(BeneficiarioMapper::toDTO).toList();
        return ResponseEntity.ok(listarBeneficiario);
    }
    @PostMapping
    public ResponseEntity<BeneficiarioDTO> criarBeneficiario(@Valid @RequestBody BeneficiarioDTO beneficiarioDTO) {
        Beneficiario respostaBeneficiario = beneficiarioService.criarBeneficiario(BeneficiarioMapper.toEntity(beneficiarioDTO));
        return ResponseEntity.ok(BeneficiarioMapper.toDTO(respostaBeneficiario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BeneficiarioDTO> atualizarBeneficiario(@PathVariable Long id, @Valid @RequestBody BeneficiarioDTO beneficiarioDTO) {
        Beneficiario respostaBeneficiario = beneficiarioService.atualizarBeneficiario(id, BeneficiarioMapper.toEntity(beneficiarioDTO));
        return ResponseEntity.ok(BeneficiarioMapper.toDTO(respostaBeneficiario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarBeneficiario(@PathVariable Long id) {
        beneficiarioService.deletarBeneficiario(id);
        return ResponseEntity.noContent().build();
    }

}
