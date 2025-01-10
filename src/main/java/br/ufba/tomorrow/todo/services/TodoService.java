package br.ufba.tomorrow.todo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.ufba.tomorrow.todo.domain.Todo;
import br.ufba.tomorrow.todo.dto.TodoCriarDTO;
import br.ufba.tomorrow.todo.dto.TodoDTO;
import br.ufba.tomorrow.todo.mappers.TodoMapper;
import br.ufba.tomorrow.todo.repository.TodoRepository;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public TodoDTO criar(TodoCriarDTO todoCriarDTO) {
        Todo todo = TodoMapper.INSTANCE.toEntity(todoCriarDTO);
        Todo todoSalvo = todoRepository.save(todo);
        TodoDTO todoSalvoDTO = TodoMapper.INSTANCE.toDTO(todoSalvo);

        return todoSalvoDTO;
    }
}
