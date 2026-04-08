package com.cars.cars.persistence.crud;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cars.cars.domain.dto.CarDTO;
import com.cars.cars.persistence.model.Car;

public interface CarsCrud extends JpaRepository<Car, Long> {
    CarDTO findFirstByModel(String model);
}
