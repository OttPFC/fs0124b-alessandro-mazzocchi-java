package com.progetto.M2S1G5PROGETTO.dao;

import com.progetto.M2S1G5PROGETTO.entities.Prenotazioni;
import com.progetto.M2S1G5PROGETTO.repositories.PrenotazioniRepository;
import com.progetto.M2S1G5PROGETTO.services.PrenotazioniDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Slf4j
public class JpaPrenotazioniDao implements PrenotazioniDao {

    @Autowired
    private PrenotazioniRepository prenotazioniRepository;

    @Override
    @Transactional
    public void insert(Prenotazioni p) {
        log.debug("JpaPrenotazioniDao.insert()");
        prenotazioniRepository.save(p);
    }

    @Override
    @Transactional
    public void update(Prenotazioni p) {
        log.debug("JpaPrenotazioniDao.update()");
        prenotazioniRepository.save(p);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        log.debug("JpaPrenotazioniDao.delete()");
        prenotazioniRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Prenotazioni getById(Integer id) {
        log.debug("JpaPrenotazioniDao.getById()");
        return prenotazioniRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Prenotazioni> getAll() {
        log.debug("JpaPrenotazioniDao.getAll()");
        return prenotazioniRepository.findAll();
    }
}
