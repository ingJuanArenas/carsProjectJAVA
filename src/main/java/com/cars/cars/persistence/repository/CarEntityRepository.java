package com.cars.cars.persistence.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cars.cars.domain.dto.CarDTO;
import com.cars.cars.domain.dto.UpdateDTO;
import com.cars.cars.domain.exception.CarAlreadyExistsException;
import com.cars.cars.domain.exception.CarNotFoundException;
import com.cars.cars.domain.repository.CarRepository;
import com.cars.cars.persistence.crud.CarsCrud;
import com.cars.cars.persistence.mapper.CarMapper;
import com.cars.cars.persistence.model.Car;

@Repository
public class CarEntityRepository implements CarRepository{

    private final CarsCrud carsCrud;
    private final CarMapper carMapper;

    public CarEntityRepository(CarsCrud carsCrud, CarMapper carMapper) {
        this.carsCrud = carsCrud;
        this.carMapper = carMapper;
    }

    @Override
    public List<CarDTO> getAllCars() {
        return carMapper.toDTOs(carsCrud.findAll());
    }
    
    @Override
    public CarDTO getCarById(Long id) {
        return carMapper.toDTO(carsCrud.findById(id).orElseThrow(
            () -> new CarNotFoundException("Car not found")
        ));
    }

    @Override
    public CarDTO addCar(Car car) {
        if (carsCrud.findFirstByModel(car.getModel()) != null) throw new CarAlreadyExistsException("Model Car Already Exists: " + car.getModel());
        
        return carMapper.toDTO(carsCrud.save(car));
    }

    @Override
    public CarDTO updateCar(long id, UpdateDTO updateDTO) {
       Car car = carsCrud.findById(id).orElse(null);
       
         if (car == null) throw new CarNotFoundException("Car not found with id: " + id);
        
         carMapper.updateEntityFromDTO(updateDTO, car);

       return carMapper.toDTO(carsCrud.save(car));
    }

    @Override
    public void deleteCar(long id) {
        Car car = carsCrud.findById(id).orElse(null);
        if(car == null) throw new CarNotFoundException("Car not found with id: " + id);
        carsCrud.deleteById(id);
    }
}
