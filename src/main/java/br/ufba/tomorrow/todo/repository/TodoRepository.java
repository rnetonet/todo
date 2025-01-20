package br.ufba.tomorrow.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufba.tomorrow.todo.domain.Todo;
import br.ufba.tomorrow.todo.domain.TodoStatus;
import br.ufba.tomorrow.todo.domain.Usuario;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    public List<Todo> findByUsuario(Usuario usuario);
    public List<Todo> findByUsuarioAndStatus(Usuario usuario, TodoStatus status);
}
