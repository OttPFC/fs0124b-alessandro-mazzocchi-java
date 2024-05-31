package com.gestioneeventi.M2_S3_G5_PROGETTO.config;

import com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.UserService;
import com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.security.AppUserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    JwtUtils jwt;

    @Autowired
    AppUserService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, //
                                    HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            log.info("Processing AuthTokenFilter");
            // legge lo header
            // Authorization: Bearer TOKEN
            var header = request.getHeader("Authorization");
            if (header != null && header.startsWith("Bearer")) {
                var token = header.substring(7);
                log.info("Token: {}", token);
                var username = jwt.getUsernameFromToken(token);
                log.info("Username: {}", username);
                var details = userDetailsService.loadUserByUsername(username);
                log.info("Details: {}", details);

                // a questo punto l'utente è stato completamente individuato
                // lo devo solo SCRIVERE NEL CONTESTO DI SICUREZZA
                var auth = new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // INTEGRO IL MIO SISTEMA DI AUTENTICAZIONE NEL CONTESTO SPRING
                SecurityContextHolder.getContext().setAuthentication(auth);
            }

        } catch (Exception e) {
            log.error("Exception in auth filter", e);
        }
        filterChain.doFilter(request, response);
    }
}
