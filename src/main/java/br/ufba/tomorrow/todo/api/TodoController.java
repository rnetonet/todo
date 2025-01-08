package br.ufba.tomorrow.todo.api;

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
import br.ufba.tomorrow.todo.mappers.TodoMapper;
import br.ufba.tomorrow.todo.repository.TodoRepository;

@RestController
@RequestMapping("api/v1")
public class TodoController {
    TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/todos")
    public ResponseEntity<?> listar() {
        return null;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> listarPorUsuario(@PathVariable long userId) {
        return null;
    }


    @GetMapping("/{userId}/{status}")
    public ResponseEntity<?> listarPorUsuarioEStatus(@PathVariable long userId, @PathVariable String status) {
        return null;
    }
    

    @PostMapping("/criar")
    public ResponseEntity<TodoDTO> criar(@RequestBody TodoCriarDTO todoCriarDTO) {
        Todo todo = TodoMapper.INSTANCE.toEntity(todoCriarDTO);
        Todo todoSalvo = todoRepository.save(todo);

        return ResponseEntity.ok(TodoMapper.INSTANCE.toDTO(todoSalvo));
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
