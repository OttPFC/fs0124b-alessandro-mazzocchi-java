package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.EventoDAO;
import org.example.dao.LocationDAO;
import org.example.dao.PartecipazioneDAO;
import org.example.dao.PersonaDAO;
import org.example.entities.*;

import java.time.LocalDate;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneEventi");

    public static void main(String[] args) {

    EntityManager em = emf.createEntityManager();
        EventoDAO eDao = new EventoDAO(em);
        PersonaDAO pDao = new PersonaDAO(em);
        PartecipazioneDAO parDao = new PartecipazioneDAO(em);
        LocationDAO lDao = new LocationDAO(em);
        LocalDate dataEvento = LocalDate.of(2023, 4, 20);
        LocalDate dataNascita = LocalDate.of(2083, 4, 20);
        Persona p = new Persona("Mario","Biondi","email@email.com",dataNascita, Genere.M);
        Location l = new Location("Bello de zia","Spoleto");
        Evento e = new Evento("test",dataEvento,"test", TipoEvento.PRIVATO,6,l);
        pDao.save(p);
        lDao.save(l);
        eDao.save(e);
        eDao.save(new Evento("test2",dataEvento,"test2", TipoEvento.PUBBLICO,1000,l));

        parDao.save(new Partecipazioni(p,e,StatoConferma.CONFERMATA));
        em.close();
        emf.close();
    }
}