package com.cars.cars.web.exception;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cars.cars.domain.exception.AlreadyExistsException;
import com.cars.cars.domain.exception.NotFoundException;


@RestControllerAdvice
public class ServiceExceptionHandler {
    
    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<Error> handleCarAlreadyExistsException(AlreadyExistsException ex) {
        return ResponseEntity.status(409).body(new Error("CarAlreadyExists", ex.getMessage()));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Error> handleCarNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(404).body(new Error("CarNotFound", ex.getMessage()));
    }

    // handling validation exception
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handleValidationException(MethodArgumentNotValidException ex) {
        List<Error> errors= ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(error -> new Error("ValidationError", error.getField() + ": " + error.getDefaultMessage()))
            .toList();
        return ResponseEntity.status(400).body(errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleGeneralException(Exception ex) {
        return ResponseEntity.status(500).body(new Error("InternalServerError", "An unexpected error occurred: " + ex.getMessage()));
    }
}
