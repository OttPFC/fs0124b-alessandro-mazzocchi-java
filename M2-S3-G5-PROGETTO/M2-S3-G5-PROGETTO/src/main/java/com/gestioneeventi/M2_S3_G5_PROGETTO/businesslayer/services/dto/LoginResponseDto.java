package com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class LoginResponseDto extends DtoBase {
    private Long id;
    private String username;
    private String email;
    private List<String> roles;
    private String token;

    @Builder(setterPrefix = "with")
    public LoginResponseDto(Long id, String username, String email, List<String> roles, String token) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.token = token;
    }
}
