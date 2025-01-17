package br.ufba.tomorrow.todo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.ufba.tomorrow.todo.domain.Usuario;
import br.ufba.tomorrow.todo.dto.UsuarioAtualizarDTO;
import br.ufba.tomorrow.todo.dto.UsuarioCriarDTO;
import br.ufba.tomorrow.todo.dto.UsuarioDTO;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    Usuario toEntity(UsuarioDTO usuarioDTO);
    
    Usuario toEntity(UsuarioCriarDTO usuarioDTO);

    Usuario toEntity(UsuarioAtualizarDTO usuarioAtualizarDTO);

    UsuarioDTO toDTO(Usuario usuario);
}
