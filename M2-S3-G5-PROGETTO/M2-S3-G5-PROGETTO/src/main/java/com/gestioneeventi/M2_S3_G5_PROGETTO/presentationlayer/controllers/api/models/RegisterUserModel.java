package com.gestioneeventi.M2_S3_G5_PROGETTO.presentationlayer.controllers.api.models;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record RegisterUserModel(
        @NotBlank @Length(max = 125) String username,
        @NotBlank @Length(max = 15) String password,
        @NotBlank @Length(max = 50) String email,
        @NotBlank @Length(max = 50) String roles) {
}
