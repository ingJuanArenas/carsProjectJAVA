package com.cars.cars.domain.exception;

public class CarAlreadyExistsException extends RuntimeException {
    public CarAlreadyExistsException(String message) {
        super(message);
    }
    
}
