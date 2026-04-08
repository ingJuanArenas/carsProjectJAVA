package com.cars.cars.domain.repository;

import java.util.List;

import com.cars.cars.domain.dto.UserDTO;
import com.cars.cars.persistence.model.Role;

public interface UserRepository {
    
    List<UserDTO> getAll();
    List<UserDTO> getByRole(Role role);
    UserDTO getByUsername(String username);
    UserDTO save(UserDTO user);
    UserDTO update(String username, UserDTO user);
    void delete(String username);
}
