package br.com.flowlife.controllers;

import br.com.flowlife.controllers.dtos.FuncionarioDTO;
import br.com.flowlife.entities.Funcionario;
import br.com.flowlife.services.FuncionarioService;
import br.com.flowlife.services.mapper.FuncionarioMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
@Tag(name = "Funcionario", description = "CRUD do Funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> buscarFuncionario(@Valid @PathVariable Long id) {
        Funcionario funcionario = funcionarioService.buscarFuncionarioID(id);
        return ResponseEntity.ok(FuncionarioMapper.toDTO(funcionario));
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> listarFuncionario() {
        List<FuncionarioDTO> listarFuncionario = funcionarioService.procurarFuncionario().stream().map(FuncionarioMapper::toDTO).toList();
        return ResponseEntity.ok(listarFuncionario);
    }
    @GetMapping("/page")
    public ResponseEntity<List<FuncionarioDTO>> listarFuncionarioPage(Pageable pageable) {
        List<FuncionarioDTO> listarFuncionario = funcionarioService.procurarFuncionarioPage(pageable).stream().map(FuncionarioMapper::toDTO).toList();
        return ResponseEntity.ok(listarFuncionario);
    }
    @PostMapping
    public ResponseEntity<FuncionarioDTO> criarFuncionario(@Valid @RequestBody FuncionarioDTO funcionarioDTO) {
        Funcionario respostaFuncionario = funcionarioService.criarFuncionario(FuncionarioMapper.toEntity(funcionarioDTO));
        return ResponseEntity.ok(FuncionarioMapper.toDTO(respostaFuncionario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> atualizarFuncionario(@PathVariable Long id, @Valid @RequestBody FuncionarioDTO funcionarioDTO) {
        Funcionario respostaFuncionario = funcionarioService.atualizarFuncionario(id, FuncionarioMapper.toEntity(funcionarioDTO));
        return ResponseEntity.ok(FuncionarioMapper.toDTO(respostaFuncionario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
        funcionarioService.deletarFuncionario(id);
        return ResponseEntity.noContent().build();
    }
}
