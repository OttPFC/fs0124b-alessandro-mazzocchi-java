package com.gestioneeventi.M2_S3_G5_PROGETTO.presentationlayer.controllers.api.models;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
public record LoginModel(@NotBlank @Length(max = 125) String username, //
                         @NotBlank @Length(max = 15) String password) {
}
