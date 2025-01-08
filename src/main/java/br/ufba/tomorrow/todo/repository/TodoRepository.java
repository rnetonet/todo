package br.ufba.tomorrow.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufba.tomorrow.todo.domain.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
