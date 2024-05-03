package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.entities.Utente;

public class UtenteDAO {

    private EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utente) {
    try{
        em.getTransaction().begin();
        em.persist(utente);
        em.getTransaction().commit();
        System.out.println("Utente salvato correttamente");
        }catch(Exception e){
        em.getTransaction().rollback();
        System.out.println("Errore durante il salvataggio dell'utente");
        }
    }

    public Utente findByTessera(long tessera){
        return em.find(Utente.class, tessera);
    }

    public void delete(long id) {
        try{
        em.getTransaction().begin();
        Utente utente = em.find(Utente.class, id);
        if (utente != null) {
            em.remove(utente);
            em.getTransaction().commit();
            System.out.println("Utente eliminato correttamente");
        }
        }catch(Exception e){
        em.getTransaction().rollback();
        System.out.println("Errore durante l'eliminazione dell'utente");
        }
    }
}
