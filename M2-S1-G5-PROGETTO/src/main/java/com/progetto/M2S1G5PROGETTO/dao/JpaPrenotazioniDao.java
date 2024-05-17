package com.progetto.M2S1G5PROGETTO.dao;

import com.progetto.M2S1G5PROGETTO.entities.Prenotazioni;
import com.progetto.M2S1G5PROGETTO.repositories.PrenotazioniRepository;
import com.progetto.M2S1G5PROGETTO.services.PrenotazioniDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Slf4j
public class JpaPrenotazioniDao implements PrenotazioniDao {

    @Autowired
    private PrenotazioniRepository prenotazioniRepository;
    @Override
    public void insert(Prenotazioni p) {
        prenotazioniRepository.save(p);
    }

    @Override
    public void update(Prenotazioni p) {
        prenotazioniRepository.save(p);
    }

    @Override
    public void delete(Integer id) {
        prenotazioniRepository.deleteById(id);
    }

    @Override
    public Prenotazioni getById(Integer id) {
        return prenotazioniRepository.findById(id).orElse(null);
    }

    @Override
    public List<Prenotazioni> getAll() {
        return prenotazioniRepository.findAll();
    }
}
