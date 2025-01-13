package br.ufba.tomorrow.todo.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private int status;
    private String message;
    private long timestamp;
}
