package com.progetto.M2S1G5PROGETTO.dao;

import com.progetto.M2S1G5PROGETTO.entities.Utente;
import com.progetto.M2S1G5PROGETTO.repositories.UtenteRepository;
import com.progetto.M2S1G5PROGETTO.services.UtenteDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Primary
@Slf4j
public class JpaUtenteDao implements UtenteDao {

    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    public void insert(Utente utente) {
        log.debug("JpaUtenteDao.insert()");
        utenteRepository.save(utente);
    }

    @Override
    public void update(Utente utente) {
        log.debug("JpaUtenteDao.update()");
        utenteRepository.save(utente);
    }

    @Override
    public void delete(Integer id) {
        log.debug("JpaUtenteDao.delete()");
        utenteRepository.deleteById(id);
    }

    @Override
    public Utente getById(Integer id) {
        log.debug("JpaUtenteDao.getById()");
        return utenteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Utente> getAll() {
        log.debug("JpaUtenteDao.getAll()");
        return utenteRepository.findAll();
    }
}
