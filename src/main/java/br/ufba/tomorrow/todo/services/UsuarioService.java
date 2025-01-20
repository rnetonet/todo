package br.ufba.tomorrow.todo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufba.tomorrow.todo.domain.Usuario;
import br.ufba.tomorrow.todo.dto.UsuarioAtualizarDTO;
import br.ufba.tomorrow.todo.dto.UsuarioCriarDTO;
import br.ufba.tomorrow.todo.dto.UsuarioDTO;
import br.ufba.tomorrow.todo.mappers.UsuarioMapper;
import br.ufba.tomorrow.todo.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    public List<UsuarioDTO> listar() {
        List<UsuarioDTO> usuarios = usuarioRepository.findByAtivo(true).stream().map(usuarioMapper::toDTO)
                .collect(Collectors.toList());
        return usuarios;
    }

    public UsuarioDTO criar(UsuarioCriarDTO usuarioCriarDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioCriarDTO);
        usuario = usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(usuario);
    }

    public UsuarioDTO atualizar(UsuarioAtualizarDTO usuarioAtualizarDTO) {
        Usuario usuario = usuarioRepository.findById(usuarioAtualizarDTO.getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Usuario usuarioAtualizado = usuarioMapper.toEntity(usuarioAtualizarDTO);
        usuarioAtualizado = usuarioRepository.save(usuarioAtualizado);

        return usuarioMapper.toDTO(usuario);
    }

    public UsuarioDTO deletar(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        
        usuario.setAtivo(false);
        usuarioRepository.save(usuario);

        return usuarioMapper.toDTO(usuario);
    }
}
