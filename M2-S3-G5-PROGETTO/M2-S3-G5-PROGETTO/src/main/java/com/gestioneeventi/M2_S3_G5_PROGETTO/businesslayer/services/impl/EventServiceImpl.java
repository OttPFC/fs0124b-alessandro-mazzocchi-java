package com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.impl;

import com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.EventService;
import com.gestioneeventi.M2_S3_G5_PROGETTO.datalayer.entities.Event;
import com.gestioneeventi.M2_S3_G5_PROGETTO.datalayer.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<Event> findEventById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<Event> findByLocation(String location) {
        return eventRepository.findByLocation(location);
    }
}
