package com.progetto.M2_S3_G1.services;


import com.progetto.M2_S3_G1.repositories.UserRepository;
import com.progetto.M2_S3_G1.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
