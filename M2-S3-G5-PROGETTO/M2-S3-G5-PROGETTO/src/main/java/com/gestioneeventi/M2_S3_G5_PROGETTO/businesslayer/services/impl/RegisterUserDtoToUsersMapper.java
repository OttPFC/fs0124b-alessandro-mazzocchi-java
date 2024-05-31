package com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.impl;

import com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.Mapper;
import com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.dto.RegisterUserDto;
import com.gestioneeventi.M2_S3_G5_PROGETTO.datalayer.entities.Users;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserDtoToUsersMapper implements Mapper<RegisterUserDto, Users> {

    @Override
    public Users map(RegisterUserDto input) {
        Users user = new Users();
        user.setUsername(input.getUsername());
        user.setEmail(input.getEmail());
        user.setPassword(input.getPassword());
        return user;
    }
}
