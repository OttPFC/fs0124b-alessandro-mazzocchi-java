package com.progetto.M2S1G5PROGETTO.services;

import com.progetto.M2S1G5PROGETTO.entities.Edificio;

import java.util.List;

public interface EdificioDao {

    public void insert(Edificio e);

    public void update(Edificio e);
    public void delete(Integer id);
    public Edificio getById(Integer id);
    public List<Edificio> getAll();
}
