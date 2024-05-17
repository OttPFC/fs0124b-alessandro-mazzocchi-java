package com.progetto.M2S1G5PROGETTO.repositories;

import com.progetto.M2S1G5PROGETTO.entities.Edificio;
import com.progetto.M2S1G5PROGETTO.entities.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione,Integer> {
    List<Postazione> findByEdificio(Edificio e);
}
