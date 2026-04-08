package com.cars.cars.persistence.repository;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.cars.cars.domain.dto.UserDTO;
import com.cars.cars.domain.exception.NotFoundException;
import com.cars.cars.domain.repository.UserRepository;
import com.cars.cars.persistence.crud.UserCrud;
import com.cars.cars.persistence.mapper.UserMapper;
import com.cars.cars.persistence.model.Role;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserCrud userCrud;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserRepositoryImpl(UserCrud userCrud, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userCrud = userCrud;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserDTO> getAll() {
        var users = userCrud.findAll();
      return userMapper.toDTOs(users);
    }

    @Override
    public List<UserDTO> getByRole(Role role) {
        var users = userCrud.findByRole(role);
      return userMapper.toDTOs(users);
    }

    @Override
    public UserDTO getByUsername(String username) {
        var user = userCrud.findById(username).orElseThrow(()-> new NotFoundException("Username not found"));
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO save(UserDTO user) {
        var userEntity = userMapper.toEntity(user);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        var savedUser = userCrud.save(userEntity);
        return userMapper.toDTO(savedUser);
    }

    @Override
    public UserDTO update(String username, UserDTO user) {
        var existingUser = userCrud.findById(username).orElseThrow(() -> new NotFoundException("Username not found"));
        userMapper.updateEntityFromDTO(user, existingUser);
        var updatedUser = userCrud.save(existingUser);
        return userMapper.toDTO(updatedUser);

    }

    @Override
    public void delete(String username) {
        var existingUser = userCrud.findById(username).orElseThrow(() -> new NotFoundException("Username not found"));
        userCrud.delete(existingUser);
    }
    
}
