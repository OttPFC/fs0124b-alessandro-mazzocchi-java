package com.progetto.M2_S2_G5_PROGETTO.repositories;

import com.progetto.M2_S2_G5_PROGETTO.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
}
