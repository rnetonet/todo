package br.ufba.tomorrow.todo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.ufba.tomorrow.todo.domain.Todo;
import br.ufba.tomorrow.todo.dto.TodoCriarDTO;
import br.ufba.tomorrow.todo.dto.TodoDTO;

@Mapper
public interface TodoMapper {
    TodoMapper INSTANCE = Mappers.getMapper(TodoMapper.class);

    Todo toEntity(TodoDTO todoDTO);
    Todo toEntity(TodoCriarDTO todoDTO);
    
    TodoDTO toDTO(Todo todo);
    TodoCriarDTO toCriarDTO(Todo todo);
}
