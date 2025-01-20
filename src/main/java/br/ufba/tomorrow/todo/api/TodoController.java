package br.ufba.tomorrow.todo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufba.tomorrow.todo.domain.TodoStatus;
import br.ufba.tomorrow.todo.dto.TodoAtualizarDTO;
import br.ufba.tomorrow.todo.dto.TodoCriarDTO;
import br.ufba.tomorrow.todo.dto.TodoDTO;
import br.ufba.tomorrow.todo.services.TodoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/listar")
    public ResponseEntity<List<TodoDTO>> listar() {
        return ResponseEntity.ok(todoService.listar());
    }

    @GetMapping("/listarPorUsuario/{idUsuario}")
    public ResponseEntity<List<TodoDTO>> listarPorUsuario(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(todoService.listarPorUsuario(idUsuario));
    }

    @GetMapping("/listarPorUsuarioStatus/{idUsuario}/{status}")
    public ResponseEntity<List<TodoDTO>> listarPorUsuarioStatus(@PathVariable Long idUsuario, @PathVariable TodoStatus status) {
        return ResponseEntity.ok(todoService.listarPorUsuarioStatus(idUsuario, status));
    }

    @PostMapping("/criar")
    public ResponseEntity<TodoDTO> criar(@Valid @RequestBody TodoCriarDTO todoCriarDTO) {
        return ResponseEntity.ok(todoService.criar(todoCriarDTO));
    }

    @PatchMapping("/atualizar")
    public ResponseEntity<TodoDTO> atualizar(@Valid @RequestBody TodoAtualizarDTO todoAtualizarDTO) {
        return ResponseEntity.ok(todoService.atualizar(todoAtualizarDTO));
    }

    @PatchMapping("/concluir/{id}")
    public ResponseEntity<TodoDTO> concluir(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.atualizarStatus(id, TodoStatus.CONCLUIDO));
    }

    @DeleteMapping("/deletar/{todoId}")
    public ResponseEntity<TodoDTO> deletar(@PathVariable Long todoId) {
        return ResponseEntity.ok(todoService.deletar(todoId));
    }
}
