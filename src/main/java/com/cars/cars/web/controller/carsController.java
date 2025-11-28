package com.cars.cars.web.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cars.cars.domain.dto.CarDTO;
import com.cars.cars.domain.dto.UpdateDTO;
import com.cars.cars.domain.service.CarService;
import com.cars.cars.persistence.model.Car;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/cars")
@Tag(name = "Cars", description = "Operations related to cars")
public class carsController {

    private final CarService carService;

    public carsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    @Operation(summary = "Get all cars", description = "Retrieve a list of all cars")
    public ResponseEntity<List<CarDTO>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get car by ID", description = "Retrieve a car by its ID")
    @ApiResponse(responseCode = "200", description = "Car found")
    @ApiResponse(responseCode = "404", description = "Car not found", content = @Content)
    public ResponseEntity<CarDTO> getCarById(@Parameter @PathVariable Long id) {        
        return ResponseEntity.ok(carService.getCarById(id));
    }
    
    @PostMapping
    @Operation(summary = "Add a new car", description = "Create a new car entry")
    @ApiResponse(responseCode = "201", description = "Car created successfully")
    public ResponseEntity<CarDTO> addCar(@Parameter @RequestBody @Valid Car car) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.addCar(car));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing car", description = "Update the details of an existing car")
    @ApiResponse(responseCode = "200", description = "Car updated successfully")
    @ApiResponse(responseCode = "404", description = "Car not found", content = @Content)
    public ResponseEntity<CarDTO> updateCar(@Parameter @PathVariable long id, @Parameter @RequestBody @Valid UpdateDTO updateDTO){
        return ResponseEntity.ok(carService.updateCar(id, updateDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a car", description = "Remove a car from the system by its ID")
    @ApiResponse(responseCode = "204", description = "Car deleted successfully")
    @ApiResponse(responseCode = "404", description = "Car not found", content = @Content)
    public ResponseEntity<Void> deleteCar(@Parameter @PathVariable long id){
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
    
}
