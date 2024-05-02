package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.entities.Evento;

public class EventoDAO {

    private EntityManager em;
    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {

        try{
            em.getTransaction().begin();
            em.persist(evento);
            em.getTransaction().commit();
            System.out.println("Evento salvato con successo");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Evento getById(long id) {
        return em.find(Evento.class, id);
    }

    public void delete(long id) {
        Evento evento = getById(id);
        try{
            em.getTransaction().begin();
            em.remove(evento);
            em.getTransaction().commit();
            System.out.println("Evento eliminato con successo");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
