package br.com.fiap.controllers;

import br.com.fiap.controllers.dto.FuncionarioDTO;
import br.com.fiap.entities.Funcionario;
import br.com.fiap.services.FuncionarioService;
import br.com.fiap.services.Mapper.FuncionarioMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> buscarFuncionario(@PathVariable Long id) {
        Funcionario funcionario = funcionarioService.buscarFuncionarioID(id);
        return ResponseEntity.ok(FuncionarioMapper.toDTO(funcionario));
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> listFuncionario() {
        List<FuncionarioDTO> listarFuncionario = funcionarioService.buscarFuncionario().stream().map(FuncionarioMapper::toDTO).toList();
        return ResponseEntity.ok(listarFuncionario);
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> criarFuncionario(@Valid @RequestBody FuncionarioDTO funcionarioDTO) {
        Funcionario respostaFuncionario = funcionarioService.criarFuncionario(FuncionarioMapper.toEntity(funcionarioDTO));
        return ResponseEntity.ok(FuncionarioMapper.toDTO(respostaFuncionario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> updateFuncionario(@PathVariable Long id, @Valid @RequestBody FuncionarioDTO funcionarioDTO) {
        Funcionario respostaFuncionario = funcionarioService.atualizarFuncionario(id, FuncionarioMapper.toEntity(funcionarioDTO));
        return ResponseEntity.ok(FuncionarioMapper.toDTO(respostaFuncionario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
        funcionarioService.deletarFuncionario(id);
        return ResponseEntity.noContent().build();
    }
}
