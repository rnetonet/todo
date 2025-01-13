package br.ufba.tomorrow.todo.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Future;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TodoCriarDTO {
    @NotNull
    private Long idUsuario;
    
    @NotBlank
    @Size(min = 1, max = 255)
    private String item;
    
    @NotNull
    @Future
    private LocalDate dataPrazo;
}
