package com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class RegisteredUserDto extends DtoBase {
    private Long id;
    private String username;
    private String email;
    private List<String> roles;

    @Builder(setterPrefix = "with")
    public RegisteredUserDto(Long id, String username, String email, List<String> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}
