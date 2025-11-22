package com.cars.cars.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cars.cars.domain.dto.CarDTO;
import com.cars.cars.domain.repository.CarRepository;
import com.cars.cars.persistence.model.Car;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarDTO> getAllCars() {
        return carRepository.getAllCars();
    }

    public CarDTO getCarById(Long id) {
        return carRepository.getCarById(id);
    }

    public CarDTO addCar(Car car) {
        return carRepository.addCar(car);
    }
}
