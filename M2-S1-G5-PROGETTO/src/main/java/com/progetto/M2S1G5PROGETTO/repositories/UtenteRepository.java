package com.progetto.M2S1G5PROGETTO.repositories;

import com.progetto.M2S1G5PROGETTO.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente,Integer> {


}
