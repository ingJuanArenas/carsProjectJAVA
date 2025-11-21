package com.cars.cars.domain.repository;

import java.util.List;

import com.cars.cars.domain.dto.CarDTO;

public interface CarRepository {
    List<CarDTO> getAllCars();
    CarDTO getCarById(Long id);
}
