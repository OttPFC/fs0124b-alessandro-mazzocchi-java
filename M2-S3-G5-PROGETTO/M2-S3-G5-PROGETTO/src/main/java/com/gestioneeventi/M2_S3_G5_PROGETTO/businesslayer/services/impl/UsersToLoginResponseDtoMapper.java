package com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.impl;

import com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.Mapper;
import com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.dto.LoginResponseDto;
import com.gestioneeventi.M2_S3_G5_PROGETTO.datalayer.entities.Users;
import org.springframework.stereotype.Component;

@Component
public class UsersToLoginResponseDtoMapper implements Mapper<Users, LoginResponseDto> {

    @Override
    public LoginResponseDto map(Users input) {
        LoginResponseDto dto = new LoginResponseDto();
        dto.setUsername(input.getUsername());
        // Mappa altri campi se necessario
        return dto;
    }
}
