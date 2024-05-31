package com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.impl;

import com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.Mapper;
import com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.UserService;
import com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.dto.LoginResponseDto;
import com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.dto.RegisterUserDto;
import com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.dto.RegisteredUserDto;
import com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.exceptions.InvalidLoginException;
import com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.exceptions.PersistEntityException;
import com.gestioneeventi.M2_S3_G5_PROGETTO.config.JwtUtils;
import com.gestioneeventi.M2_S3_G5_PROGETTO.datalayer.entities.RoleEntity;
import com.gestioneeventi.M2_S3_G5_PROGETTO.datalayer.entities.Users;
import com.gestioneeventi.M2_S3_G5_PROGETTO.datalayer.repositories.RolesRepository;
import com.gestioneeventi.M2_S3_G5_PROGETTO.datalayer.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UserRepository users;
    @Autowired
    private RolesRepository roles;

    @Autowired
    private AuthenticationManager auth;

    @Autowired
    private JwtUtils jwt;

    @Autowired
    Mapper<RegisterUserDto, Users> mapEntity;
    @Autowired
    Mapper<Users, RegisteredUserDto> mapRegisteredUser;
    @Autowired
    Mapper<Users, LoginResponseDto> mapLogin;

    @Override
    public RegisteredUserDto register(RegisterUserDto user) {
        try {
            var u = mapEntity.map(user);
            var p = encoder.encode(user.getPassword());
            log.info("Password encrypted: {}", p);
            u.setPassword(p);
            if (user.getRoles() != null)
                Stream.of(user.getRoles().split(",")).forEach(r -> u.getRoles().add(roles.findOneByName(r)
                        .orElse(roles.save(RoleEntity.builder().withName(r).build()))));
            return mapRegisteredUser.map(users.save(u));
        } catch (Exception e) {
            log.error(String.format("Exception saving user %s", user), e);
            throw new PersistEntityException(user);
        }
    }

    @Override
    public Optional<LoginResponseDto> login(String username, String password) {
        try {
            var a = auth.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            a.getAuthorities();
            SecurityContextHolder.getContext().setAuthentication(a);

            var dto = mapLogin.map(users.findOneByUsername(username).orElseThrow());
            dto.setToken(jwt.generateToken(a));
            return Optional.of(dto);
        } catch (NoSuchElementException e) {
            log.error("User not found", e);
            throw new InvalidLoginException(username, password);
        } catch (AuthenticationException e) {
            log.error("Authentication failed", e);
            throw new InvalidLoginException(username, password);
        }
    }

    @Override
    public Optional<RegisteredUserDto> get(long id) {
        try {
            return Optional.of(mapRegisteredUser.map(users.findById(id).orElseThrow()));
        } catch (Exception e) {
            log.error(String.format("User not found for id %s", id), e);
            return Optional.empty();
        }
    }
}
