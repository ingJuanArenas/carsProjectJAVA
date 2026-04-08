package com.cars.cars.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.cars.cars.domain.dto.UserDTO;
import com.cars.cars.persistence.model.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    UserEntity toEntity (UserDTO userDTO);


    UserDTO toDTO (UserEntity userEntity);

    List<UserDTO> toDTOs(List<UserEntity> entities);

    void updateEntityFromDTO( UserDTO userDTO, @MappingTarget UserEntity userEntity);
}
