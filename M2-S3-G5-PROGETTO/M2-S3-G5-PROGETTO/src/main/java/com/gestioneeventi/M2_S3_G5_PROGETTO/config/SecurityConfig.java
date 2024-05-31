package com.gestioneeventi.M2_S3_G5_PROGETTO.config;

import com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    PasswordEncoder stdPasswordEncoder() {
        return new BCryptPasswordEncoder(11);
    }

    @Bean
    JwtRequestFilter authenticationJwtToken() {
        return new JwtRequestFilter();
    }

    @SuppressWarnings("removal")
    @Bean
    AuthenticationManager authenticationManager(HttpSecurity http,
                                                PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder)
                .and().build();
    }

    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
        http
                .csrf(c -> c.disable())
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers("/api/users/login").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/users").permitAll()
                                .requestMatchers("/**").authenticated()
                ) //
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(
                        sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))//
                .addFilterBefore(authenticationJwtToken(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
