package br.ufba.tomorrow.todo.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TodoDTO {
    private Long id;
    private Long idUsuario;
    private String item;
    private LocalDate dataPrazo;
}
