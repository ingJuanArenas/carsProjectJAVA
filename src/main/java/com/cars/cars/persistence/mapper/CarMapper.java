package com.cars.cars.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cars.cars.domain.dto.CarDTO;
import com.cars.cars.persistence.model.Car;

@Mapper(componentModel = "spring")
public interface CarMapper {


    @org.mapstruct.Mapping(source = "brand", target = "brand")
    @org.mapstruct.Mapping(source = "model", target = "model")
    @org.mapstruct.Mapping(source = "year", target = "year")
    @org.mapstruct.Mapping(source = "price", target = "price")
    Car toEntity(CarDTO carDTO);
    CarDTO toDTO(Car car);
    List<CarDTO> toDTOs(Iterable<Car> cars);
    
} 
