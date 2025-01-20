package org.example.mayjavaspring2024.controllers;

import org.example.mayjavaspring2024.dto.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDto> handleNullPointerException() {
        return ResponseEntity
                .badRequest()
                .body(ErrorDto.builder()
                        .message("Car not found")
                        .time(OffsetDateTime.now())
                        .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        String details = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField().concat(" ").concat(error.getDefaultMessage()))
                .collect(Collectors.joining(", \n"));

        return ResponseEntity
                .badRequest()
                .body(ErrorDto.builder()
                        .message(details)
                        .time(OffsetDateTime.now())
                        .build()
                );
    }
}
