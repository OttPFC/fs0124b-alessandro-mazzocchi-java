package com.progetto.M2S1G5PROGETTO.services;

import com.progetto.M2S1G5PROGETTO.entities.Edificio;
import com.progetto.M2S1G5PROGETTO.entities.Prenotazioni;

import java.util.List;

public interface PrenotazioniDao {

    public void insert(Prenotazioni p);

    public void update(Prenotazioni p);
    public void delete(Integer id);
    public Prenotazioni getById(Integer id);
    public List<Prenotazioni> getAll();
}
