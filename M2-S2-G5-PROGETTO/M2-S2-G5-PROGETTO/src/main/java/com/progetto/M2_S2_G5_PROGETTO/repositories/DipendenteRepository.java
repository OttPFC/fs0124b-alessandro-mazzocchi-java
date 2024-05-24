package com.progetto.M2_S2_G5_PROGETTO.repositories;

import com.progetto.M2_S2_G5_PROGETTO.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DipendenteRepository extends JpaRepository<Dipendente,Integer> {

    Optional<Dipendente> findByEmail(String email);
}
