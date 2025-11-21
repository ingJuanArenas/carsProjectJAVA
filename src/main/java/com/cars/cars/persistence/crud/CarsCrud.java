package com.cars.cars.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.cars.cars.persistence.model.Car;

public interface CarsCrud extends CrudRepository<Car, Long> {
    
}
