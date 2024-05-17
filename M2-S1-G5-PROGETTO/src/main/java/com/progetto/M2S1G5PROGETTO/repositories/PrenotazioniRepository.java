package com.progetto.M2S1G5PROGETTO.repositories;

import com.progetto.M2S1G5PROGETTO.entities.Prenotazioni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioniRepository extends JpaRepository<Prenotazioni,Integer> {
}
