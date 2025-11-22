package com.cars.cars.domain.repository;

import java.util.List;

import com.cars.cars.domain.dto.CarDTO;
import com.cars.cars.persistence.model.Car;

public interface CarRepository {
    List<CarDTO> getAllCars();
    CarDTO getCarById(Long id);
    CarDTO addCar(Car car);
}
