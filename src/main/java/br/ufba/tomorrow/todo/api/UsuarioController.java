package br.ufba.tomorrow.todo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufba.tomorrow.todo.dto.UsuarioAtualizarDTO;
import br.ufba.tomorrow.todo.dto.UsuarioCriarDTO;
import br.ufba.tomorrow.todo.dto.UsuarioDTO;
import br.ufba.tomorrow.todo.services.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDTO>> listar() {
        return ResponseEntity.ok(usuarioService.listar());
    }

    @PostMapping("/criar")
    public ResponseEntity<UsuarioDTO> criar(@Valid @RequestBody UsuarioCriarDTO usuarioCriarDTO) {
        return ResponseEntity.ok(usuarioService.criar(usuarioCriarDTO));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<UsuarioDTO> atualizar(@Valid @RequestBody UsuarioAtualizarDTO usuarioAtualizarDTO) {
        return ResponseEntity.ok(usuarioService.atualizar(usuarioAtualizarDTO));
    }

    @DeleteMapping("/deletar/{todoId}")
    public ResponseEntity<UsuarioDTO> deletar(@PathVariable Long todoId) {
        return ResponseEntity.ok(usuarioService.deletar(todoId));
    }
}
