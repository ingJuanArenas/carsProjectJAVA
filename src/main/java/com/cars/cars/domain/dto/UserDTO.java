package com.cars.cars.domain.dto;

import com.cars.cars.persistence.model.Role;

public record UserDTO(
    String username,
    String password,
    Role role,
    boolean disabled
) {}
