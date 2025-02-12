package br.ufba.tomorrow.todo.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import br.ufba.tomorrow.todo.domain.TodoStatus;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TodoDTO {
    @NotNull
    private Long id;
    
    @NotNull
    private Long idUsuario;
    
    @NotBlank
    @Size(min = 1, max = 255)
    private String item;
    
    @NotNull
    private LocalDate dataPrazo;
    
    private LocalDate dataConclusao;
    
    @NotNull
    private TodoStatus status;
}
