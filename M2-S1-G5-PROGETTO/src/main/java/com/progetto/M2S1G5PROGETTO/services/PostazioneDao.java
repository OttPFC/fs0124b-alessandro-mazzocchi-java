package com.progetto.M2S1G5PROGETTO.services;

import com.progetto.M2S1G5PROGETTO.entities.Edificio;
import com.progetto.M2S1G5PROGETTO.entities.Postazione;

import java.util.List;

public interface PostazioneDao {

    public void insert(Postazione p);
    public void update(Postazione p);
    public void delete(Integer id);
    public Postazione getById(Integer id);
    public List<Postazione> getByBuilding(Edificio e);
}
