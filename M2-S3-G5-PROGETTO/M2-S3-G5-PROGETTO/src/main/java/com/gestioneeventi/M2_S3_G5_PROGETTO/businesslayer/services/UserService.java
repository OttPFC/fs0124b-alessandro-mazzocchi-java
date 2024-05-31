package com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services;

import com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.dto.LoginResponseDto;
import com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.dto.RegisterUserDto;
import com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.dto.RegisteredUserDto;

import java.util.Optional;


public interface UserService {
    RegisteredUserDto register(RegisterUserDto user);

    Optional<LoginResponseDto> login(String username, String password);

    Optional<RegisteredUserDto> get(long id);
}
