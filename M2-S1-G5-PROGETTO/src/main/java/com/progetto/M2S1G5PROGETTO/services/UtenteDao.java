package com.progetto.M2S1G5PROGETTO.services;

import com.progetto.M2S1G5PROGETTO.entities.Utente;

import java.util.List;

public interface UtenteDao {

    public void insert(Utente u);
    public void update(Utente u);
    public void delete(Integer id);
    public Utente getById(Integer id);
    public List<Utente> getAll();
}
