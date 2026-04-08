package com.cars.cars.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cars.cars.domain.dto.UserDTO;
import com.cars.cars.domain.exception.NotFoundException;
import com.cars.cars.persistence.model.Role;
import com.cars.cars.persistence.repository.UserRepositoryImpl;

@Service
public class UserService {
    
    private final UserRepositoryImpl userRepositoryImpl;

    public UserService(UserRepositoryImpl userRepositoryImpl) {
        this.userRepositoryImpl = userRepositoryImpl;
    }

    //get all
    public List<UserDTO> getAll() {
        var users = userRepositoryImpl.getAll();
        if (users.isEmpty()) throw new NotFoundException("No contents found");
        return users;
    }

    //get by role
    public List<UserDTO> getByRole(Role role) {
        var users = userRepositoryImpl.getByRole(role);
        if (users.isEmpty()) throw new NotFoundException("No contents found");
        return users;
    }

    //get by username
    public UserDTO getByUsername(String username) {
        return userRepositoryImpl.getByUsername(username);
    }

    public UserDTO save(UserDTO user) {
        return userRepositoryImpl.save(user);
    }

    public UserDTO update(String username, UserDTO user) {
        return userRepositoryImpl.update(username, user);
    }
    

    //delete
    public void delete(String username) {
        userRepositoryImpl.delete(username);
    }




}
