package com.cars.cars.web.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cars.cars.domain.dto.CarDTO;
import com.cars.cars.domain.service.CarService;
import com.cars.cars.persistence.model.Car;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/cars")
public class carsController {

    private final CarService carService;

    public carsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<CarDTO>> getAllCars() {
        if (carService.getAllCars().isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable Long id) {

        if (carService.getCarById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carService.getCarById(id));
    }
    
    @PostMapping
    public ResponseEntity<CarDTO> addCar(@RequestBody Car car) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.addCar(car));
    }

    
}
