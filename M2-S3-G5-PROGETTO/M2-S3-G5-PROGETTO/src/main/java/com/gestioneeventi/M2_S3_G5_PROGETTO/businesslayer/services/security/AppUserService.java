package com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.security;

import com.gestioneeventi.M2_S3_G5_PROGETTO.datalayer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    UserRepository users;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = users.findOneByUsername(username).orElseThrow();
        var applicationUser = SecurityUserDetails.build(user);
        return applicationUser;
    }
}
