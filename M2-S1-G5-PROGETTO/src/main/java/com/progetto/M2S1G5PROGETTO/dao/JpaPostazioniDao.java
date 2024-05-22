package com.progetto.M2S1G5PROGETTO.dao;

import com.progetto.M2S1G5PROGETTO.entities.Edificio;
import com.progetto.M2S1G5PROGETTO.entities.Postazione;
import com.progetto.M2S1G5PROGETTO.repositories.PostazioneRepository;
import com.progetto.M2S1G5PROGETTO.services.PostazioneDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Slf4j
public class JpaPostazioniDao implements PostazioneDao {

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Override
    @Transactional
    public void insert(Postazione p) {
        log.debug("JpaPostazioniDao.insert()");
        postazioneRepository.save(p);
    }

    @Override
    @Transactional
    public void update(Postazione p) {
        log.debug("JpaPostazioniDao.update()");
        postazioneRepository.save(p);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        log.debug("JpaPostazioniDao.delete()");
        postazioneRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Postazione getById(Integer id) {
        log.debug("JpaPostazioniDao.getById()");
        return postazioneRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Postazione> getByBuilding(Edificio e) {
        log.debug("JpaPostazioniDao.getByBuilding()");
        return postazioneRepository.findByEdificio(e);
    }
}
