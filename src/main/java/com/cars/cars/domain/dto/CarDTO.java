package com.cars.cars.domain.dto;

import java.math.BigDecimal;

public record CarDTO(
    String brand,
    String model,
    Integer year,
    BigDecimal price

) {
    
}
