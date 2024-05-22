package com.progetto.M2S1G5PROGETTO.dao;

import com.progetto.M2S1G5PROGETTO.entities.Edificio;
import com.progetto.M2S1G5PROGETTO.repositories.EdificioRepository;
import com.progetto.M2S1G5PROGETTO.services.EdificioDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Slf4j
public class JpaEdificioDao implements EdificioDao {

    @Autowired
    private EdificioRepository edificioRepository;

    @Override
    @Transactional
    public void insert(Edificio e) {
        log.debug("JpaEdificioDao.insert()");
        edificioRepository.save(e);
    }

    @Override
    @Transactional
    public void update(Edificio e) {
        log.debug("JpaEdificioDao.update()");
        edificioRepository.save(e);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        log.debug("JpaEdificioDao.delete()");
        edificioRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Edificio getById(Integer id) {
        log.debug("JpaEdificioDao.getById()");
        return edificioRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Edificio> getAll() {
        log.debug("JpaEdificioDao.findAll()");
        return edificioRepository.findAll();
    }
}
