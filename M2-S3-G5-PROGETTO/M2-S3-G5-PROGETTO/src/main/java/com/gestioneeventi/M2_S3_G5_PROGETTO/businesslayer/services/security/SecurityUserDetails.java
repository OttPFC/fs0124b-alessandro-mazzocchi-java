package com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.security;

import com.gestioneeventi.M2_S3_G5_PROGETTO.datalayer.entities.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
@Data
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class SecurityUserDetails implements UserDetails {
    private static final long serialVersionUID = 1L;

    // l'elenco dei ruoli dell'utente
    private Collection<? extends GrantedAuthority> authorities;
    private String password;
    private String username;
    @Builder.Default
    private boolean accountNonExpired = true;
    @Builder.Default
    private boolean accountNonLocked = true;
    @Builder.Default
    private boolean credentialsNonExpired = true;
    @Builder.Default
    private boolean enabled = true;

    public static SecurityUserDetails build(Users user) {
        var authorities = user.getRoles().stream() //
                .map(r -> new SimpleGrantedAuthority(r.getName())).toList();
        return SecurityUserDetails.builder() //
                .withUsername(user.getUsername()) //
                .withPassword(user.getPassword()) //
                .withAuthorities(authorities) //
                .build();
    }
}
