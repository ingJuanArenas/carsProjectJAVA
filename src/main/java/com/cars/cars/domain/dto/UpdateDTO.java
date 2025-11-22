package com.cars.cars.domain.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;

public record UpdateDTO(
    @NotBlank(message = "Brand cannot be blank")
    String model,
    Integer year,
    BigDecimal price

) {
    
}
