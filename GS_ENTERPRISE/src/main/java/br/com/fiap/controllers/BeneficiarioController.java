package br.com.fiap.controllers;

import br.com.fiap.controllers.dto.BeneficiarioDTO;
import br.com.fiap.entities.Beneficiario;
import br.com.fiap.services.BeneficiarioService;
import br.com.fiap.services.Mapper.BeneficiarioMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beneficiario")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioService beneficiarioService;

    @GetMapping("/{id}")
    public ResponseEntity<BeneficiarioDTO> buscarBeneficiario(@PathVariable Long id) {
        Beneficiario beneficiario = beneficiarioService.buscarBeneficiarioID(id);
        return ResponseEntity.ok(BeneficiarioMapper.toDTO(beneficiario));
    }

    @GetMapping
    public ResponseEntity<List<BeneficiarioDTO>> listBeneficiario() {
        List<BeneficiarioDTO> listarBeneficiario = beneficiarioService.buscarBeneficiario().stream().map(BeneficiarioMapper::toDTO).toList();
        return ResponseEntity.ok(listarBeneficiario);
    }

    @PostMapping
    public ResponseEntity<BeneficiarioDTO> criarBeneficiario(@Valid @RequestBody BeneficiarioDTO departmentDTO) {
        Beneficiario respostaBeneficiario = beneficiarioService.criarBeneficiario(BeneficiarioMapper.toEntity(departmentDTO));
        return ResponseEntity.ok(BeneficiarioMapper.toDTO(respostaBeneficiario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BeneficiarioDTO> updateBeneficiario(@PathVariable Long id, @Valid @RequestBody BeneficiarioDTO beneficiarioDTO) {
        Beneficiario respostaBeneficiario = beneficiarioService.atualizarBeneficiario(id, BeneficiarioMapper.toEntity(beneficiarioDTO));
        return ResponseEntity.ok(BeneficiarioMapper.toDTO(respostaBeneficiario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarBeneficiario(@PathVariable Long id) {
        beneficiarioService.deletarBeneficiario(id);
        return ResponseEntity.noContent().build();
    }

}
