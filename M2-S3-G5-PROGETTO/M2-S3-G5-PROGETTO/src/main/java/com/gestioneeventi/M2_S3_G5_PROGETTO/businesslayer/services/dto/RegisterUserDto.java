package com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.dto;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDto extends DtoBase {
    private String username;
    private String password;
    private String email;
    private String roles;
}
