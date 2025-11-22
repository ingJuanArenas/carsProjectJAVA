package com.cars.cars.persistence.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cars.cars.domain.dto.CarDTO;
import com.cars.cars.domain.dto.UpdateDTO;
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
        return carMapper.toDTO(carsCrud.findById(id).orElse(null));
    }

    @Override
    public CarDTO addCar(Car car) {
        return carMapper.toDTO(carsCrud.save(car));
    }

    @Override
    public CarDTO updateCar(long id, UpdateDTO updateDTO) {
       Car car = carsCrud.findById(id).orElse(null);
       if (car == null) return null;

       carMapper.updateEntityFromDTO(updateDTO, car);

       return carMapper.toDTO(carsCrud.save(car));
    }

    @Override
    public void deleteCar(long id) {
        carsCrud.deleteById(id);
    }
}
