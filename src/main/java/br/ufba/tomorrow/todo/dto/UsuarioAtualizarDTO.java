package br.ufba.tomorrow.todo.dto;

import lombok.Data;

@Data
public class UsuarioAtualizarDTO {
    private Long id;
    private String email;
    private String senha;
}