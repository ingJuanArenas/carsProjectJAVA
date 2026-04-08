package com.cars.cars.persistence.crud;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cars.cars.persistence.model.Role;
import com.cars.cars.persistence.model.UserEntity;
import java.util.List;


public interface UserCrud extends JpaRepository<UserEntity,String> {
    
    List<UserEntity> findByRole(Role role);
}
