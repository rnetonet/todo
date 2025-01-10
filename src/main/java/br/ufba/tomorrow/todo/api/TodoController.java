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

import br.ufba.tomorrow.todo.domain.Todo;
import br.ufba.tomorrow.todo.dto.TodoCriarDTO;
import br.ufba.tomorrow.todo.dto.TodoDTO;
import br.ufba.tomorrow.todo.services.TodoService;

@RestController
@RequestMapping("api/v1")
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping("/listar-todos")
    public ResponseEntity<List<TodoDTO>> listarTodos() {
        return ResponseEntity.ok(todoService.listarTodos());
    }

    @GetMapping("/listar-por-usuario/{userId}")
    public ResponseEntity<?> listarPorUsuario(@PathVariable long userId) {
        return null;
    }


    @GetMapping("/listar-por-usuario/{userId}/status/{status}")
    public ResponseEntity<?> listarPorUsuarioEStatus(@PathVariable long userId, @PathVariable String status) {
        return null;
    }
    

    @PostMapping("/criar")
    public ResponseEntity<TodoDTO> criar(@RequestBody TodoCriarDTO todoCriarDTO) {
        return ResponseEntity.ok(todoService.criar(todoCriarDTO));
    }

    @PutMapping("/atualizar/{todoId}")
    public ResponseEntity<?> atualizar(@PathVariable Long todoId, @RequestBody Todo todo) {
        return null;
    }

    @DeleteMapping("/deletar/{todoId}")
    public ResponseEntity<?> deletar(@PathVariable Long todoId) {
        return null;
    }
}
