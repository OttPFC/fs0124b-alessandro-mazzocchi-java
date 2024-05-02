package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.entities.Partecipazioni;

public class PartecipazioneDAO {

    private EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazioni p){
        try{
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Partecipazione salvata con successo");
        }catch (Exception e){
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        }
    }

    public Partecipazioni getPartecipazioni(long id){return em.find(Partecipazioni.class, id);}

    public void delete(long id){
        try{
            em.getTransaction().begin();
            em.remove(id);
            em.getTransaction().commit();
            System.out.println("Eliminato con successo");
        }catch(Exception e){
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        }
    }
}
