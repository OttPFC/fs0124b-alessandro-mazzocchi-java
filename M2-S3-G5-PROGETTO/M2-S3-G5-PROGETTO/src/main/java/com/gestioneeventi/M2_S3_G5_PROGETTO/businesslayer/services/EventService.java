package com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services;

import com.gestioneeventi.M2_S3_G5_PROGETTO.datalayer.entities.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> findAllEvents();
    Optional<Event> findEventById(Long id);
    Event saveEvent(Event event);
    void deleteEvent(Long id);
    List<Event> findByLocation(String location);
}
