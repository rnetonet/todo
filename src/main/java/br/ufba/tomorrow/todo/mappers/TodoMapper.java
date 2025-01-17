package br.ufba.tomorrow.todo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.ufba.tomorrow.todo.domain.Todo;
import br.ufba.tomorrow.todo.dto.TodoAtualizarDTO;
import br.ufba.tomorrow.todo.dto.TodoCriarDTO;
import br.ufba.tomorrow.todo.dto.TodoDTO;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    TodoMapper INSTANCE = Mappers.getMapper(TodoMapper.class);

    @Mapping(target = "usuario.id", source = "idUsuario")
    Todo toEntity(TodoDTO todoDTO);
    
    @Mapping(target = "usuario.id", source = "idUsuario")
    Todo toEntity(TodoCriarDTO todoDTO);
       
    Todo toEntity(TodoAtualizarDTO todoDTO);

    @Mapping(target = "idUsuario", source = "usuario.id")
    TodoDTO toDTO(Todo todo);
}
