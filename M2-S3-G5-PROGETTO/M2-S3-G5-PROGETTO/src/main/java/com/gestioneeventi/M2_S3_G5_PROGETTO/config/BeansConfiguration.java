package it.epicode.blog.config;

import com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.Mapper;
import com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.dto.LoginResponseDto;
import com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.dto.RegisterUserDto;
import com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.dto.RegisteredUserDto;
import com.gestioneeventi.M2_S3_G5_PROGETTO.datalayer.entities.Users;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class BeansConfiguration {
    @Bean
    @Scope("singleton")
    Mapper<RegisterUserDto, Users> mapRegisterUser2UserEntity() {
        return (input) -> Users.builder() //
                .withPassword(input.getPassword()) //
                .withUsername(input.getUsername()) //
                .build();
    }

    @Bean
    @Scope("singleton")
    Mapper<Users, RegisteredUserDto> mapUserEntity2RegisteredUser() {
        return (input) -> RegisteredUserDto.builder() ////
                .withId(input.getId()) //
                .withUsername(input.getUsername()) //
                .withRoles(input.getRoles().stream().map(r -> r.getName()).toList()) //
                .build();
    }

    @Bean
    @Scope("singleton")
    Mapper<Users, LoginResponseDto> mapUserEntity2LoginResponse() {
        return (input) -> LoginResponseDto.builder()
                .withId(input.getId())
                .withUsername(input.getUsername())
                .withRoles(input.getRoles().stream().map(r -> r.getName()).toList())
                .build();
    }
}
