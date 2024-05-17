package com.progetto.M2S1G5PROGETTO.dao;

import com.progetto.M2S1G5PROGETTO.entities.Edificio;
import com.progetto.M2S1G5PROGETTO.entities.Postazione;
import com.progetto.M2S1G5PROGETTO.repositories.PostazioneRepository;
import com.progetto.M2S1G5PROGETTO.services.PostazioneDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class JpaPostazioniDao implements PostazioneDao {

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Override
    public void insert(Postazione p) {
        log.debug("JpaPostazioniDao.insert()");
        postazioneRepository.save(p);
    }

    @Override
    public void update(Postazione p) {

        postazioneRepository.save(p);
    }

    @Override
    public void delete(Integer id) {

        postazioneRepository.deleteById(id);
    }

    @Override
    public Postazione getById(Integer id) {
        return postazioneRepository.findById(id).orElse(null);
    }

    @Override
    public List<Postazione> getByBuilding(Edificio e) {
        return postazioneRepository.findByEdificio(e);
    }

}
