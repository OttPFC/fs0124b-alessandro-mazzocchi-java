package com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.impl;

import com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.Mapper;
import com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.dto.RegisteredUserDto;
import com.gestioneeventi.M2_S3_G5_PROGETTO.datalayer.entities.Users;
import org.springframework.stereotype.Component;

@Component
public class UsersToRegisteredUserDtoMapper implements Mapper<Users, RegisteredUserDto> {

    @Override
    public RegisteredUserDto map(Users input) {
        RegisteredUserDto dto = new RegisteredUserDto();
        dto.setUsername(input.getUsername());
        dto.setEmail(input.getEmail());
        return dto;
    }
}
