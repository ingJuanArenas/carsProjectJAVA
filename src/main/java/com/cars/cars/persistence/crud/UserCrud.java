package com.cars.cars.persistence.crud;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cars.cars.persistence.model.UserEntity;

public interface UserCrud extends JpaRepository<UserEntity,String> {
    
}
