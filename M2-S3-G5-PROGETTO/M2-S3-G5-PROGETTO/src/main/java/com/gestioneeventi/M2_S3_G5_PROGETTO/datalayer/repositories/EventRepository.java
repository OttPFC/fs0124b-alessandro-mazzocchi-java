package com.gestioneeventi.M2_S3_G5_PROGETTO.datalayer.repositories;

import com.gestioneeventi.M2_S3_G5_PROGETTO.datalayer.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
    Optional<Event> findEventById(Long id);
    List<Event> findByLocation(String location);
}
