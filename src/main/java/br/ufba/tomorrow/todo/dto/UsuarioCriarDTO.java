package br.ufba.tomorrow.todo.dto;

import lombok.Data;

@Data
public class UsuarioCriarDTO {
    private String email;
    private String senha;
}