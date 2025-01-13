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
    TodoService todoService;

    @GetMapping("/listar")
    public ResponseEntity<List<TodoDTO>> listar() {
        return ResponseEntity.ok(todoService.listar());
    }

    @PostMapping("/criar")
    public ResponseEntity<TodoDTO> criar(@Valid @RequestBody TodoCriarDTO todoCriarDTO) {
        return ResponseEntity.ok(todoService.criar(todoCriarDTO));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<TodoDTO> atualizar(@Valid @RequestBody TodoAtualizarDTO todoAtualizarDTO) {
        return ResponseEntity.ok(todoService.atualizar(todoAtualizarDTO));
    }

    @PutMapping("/atualizarStatus/{id}/{status}")
    public ResponseEntity<TodoDTO> atualizarStatus(@PathVariable Long id, @PathVariable TodoStatus status) {
        return ResponseEntity.ok(todoService.atualizarStatus(id, status));
    }

    @DeleteMapping("/deletar/{todoId}")
    public ResponseEntity<TodoDTO> deletar(@PathVariable Long todoId) {
        return ResponseEntity.ok(todoService.deletar(todoId));
    }
}
