package br.com.springboot.modulo2_spring.aula4.config;

import br.com.springboot.modulo2_spring.aula4.dto.AdviceResponseDTO;
import br.com.springboot.modulo2_spring.aula4.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(exception = NotFoundException.class)
    public ResponseEntity<AdviceResponseDTO> notFoundHandler(NotFoundException nfe) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new AdviceResponseDTO(nfe.getMessage()));
    }
}
