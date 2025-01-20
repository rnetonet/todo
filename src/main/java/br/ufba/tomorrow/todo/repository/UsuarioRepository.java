package br.ufba.tomorrow.todo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufba.tomorrow.todo.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByAtivo(boolean ativo);

    Optional<Usuario> findByEmail(String username);
}
