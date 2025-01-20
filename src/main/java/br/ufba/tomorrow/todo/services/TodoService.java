package br.ufba.tomorrow.todo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufba.tomorrow.todo.domain.Todo;
import br.ufba.tomorrow.todo.domain.TodoStatus;
import br.ufba.tomorrow.todo.domain.Usuario;
import br.ufba.tomorrow.todo.dto.TodoAtualizarDTO;
import br.ufba.tomorrow.todo.dto.TodoCriarDTO;
import br.ufba.tomorrow.todo.dto.TodoDTO;
import br.ufba.tomorrow.todo.mappers.TodoMapper;
import br.ufba.tomorrow.todo.repository.TodoRepository;
import br.ufba.tomorrow.todo.repository.UsuarioRepository;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TodoMapper todoMapper;

    public TodoDTO criar(TodoCriarDTO todoCriarDTO) {
        Todo todo = todoMapper.toEntity(todoCriarDTO);
        Todo todoSalvo = todoRepository.save(todo);
        TodoDTO todoSalvoDTO = todoMapper.toDTO(todoSalvo);

        return todoSalvoDTO;
    }

    public List<TodoDTO> listar() {
        List<TodoDTO> todos = todoRepository.findAll().stream().map(todoMapper::toDTO)
                .collect(Collectors.toList());
        return todos;
    }

    public List<TodoDTO> listarPorUsuario(Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        List<TodoDTO> todos = todoRepository.findByUsuario(usuario).stream().map(todoMapper::toDTO).collect(Collectors.toList());
        return todos;
    }

    public List<TodoDTO> listarPorUsuarioStatus(Long idUsuario, TodoStatus status) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        List<TodoDTO> todos = todoRepository.findByUsuarioAndStatus(usuario, status).stream().map(todoMapper::toDTO)
                .collect(Collectors.toList());
        return todos;
    }
        

    public TodoDTO atualizar(TodoAtualizarDTO todoAtualizarDTO) {
        Todo todo = todoRepository.findById(todoAtualizarDTO.getId())
                .orElseThrow(() -> new RuntimeException("Todo não encontrado"));

        Todo todoAtualizado = todoMapper.toEntity(todoAtualizarDTO);
        todoAtualizado.setId(todo.getId());
        todoAtualizado.setUsuario(todo.getUsuario());

        todoRepository.save(todoAtualizado);

        return todoMapper.toDTO(todoAtualizado);
    }

    public TodoDTO atualizarStatus(Long todoId, TodoStatus status) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new RuntimeException("Todo não encontrado"));
        
        todo.setStatus(status);
        if (status.equals(TodoStatus.CONCLUIDO)) {
            todo.setDataConclusao(LocalDate.now());
        }

        todoRepository.save(todo);
        
        return todoMapper.toDTO(todo);
    }

    public TodoDTO deletar(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new RuntimeException("Todo não encontrado"));
        todoRepository.delete(todo);
        return todoMapper.toDTO(todo);
    }
}
