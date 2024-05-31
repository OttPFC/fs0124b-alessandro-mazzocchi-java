package com.gestioneeventi.M2_S3_G5_PROGETTO.datalayer.repositories;

import com.gestioneeventi.M2_S3_G5_PROGETTO.datalayer.entities.BaseEntity;
import com.gestioneeventi.M2_S3_G5_PROGETTO.datalayer.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findOneByUsernameAndPassword(String username, String password);
    Optional<Users> findOneByUsername(String username);
}
