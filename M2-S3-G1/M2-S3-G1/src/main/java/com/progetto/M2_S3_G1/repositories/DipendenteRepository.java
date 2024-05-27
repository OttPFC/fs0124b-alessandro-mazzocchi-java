package com.progetto.M2_S3_G1.repositories;

import com.progetto.M2_S3_G1.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DipendenteRepository extends JpaRepository<Dipendente,Integer> {

    Optional<Dipendente> findByEmail(String email);
}
