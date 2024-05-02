package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.EventoDAO;
import org.example.entities.Evento;
import org.example.entities.TipoEvento;

import java.time.LocalDate;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneEventi");

    public static void main(String[] args) {

    EntityManager em = emf.createEntityManager();
        EventoDAO eDao = new EventoDAO(em);
        LocalDate dataEvento = LocalDate.of(2023, 4, 20);
        eDao.save(new Evento("test",dataEvento,"test", TipoEvento.PRIVATO,6));
        eDao.save(new Evento("test2",dataEvento,"test2", TipoEvento.PUBBLICO,1000));

        em.close();
        emf.close();
    }
}