package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.entities.Biblioteca;
import org.example.entities.Prestito;
import org.example.entities.Utente;

import java.util.List;

public class PrestitoDAO {

    private EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito p) {
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            logInfo("Prestito salvato con successo");
        } catch (Exception e) {
            rollbackAndLogError("Prestito non salvato", e);
        }
    }

    public void findByTessera(long numeroTessera) {

            List<Prestito> p = em.createQuery("SELECT p FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera", Prestito.class)
                    .setParameter("numeroTessera", numeroTessera)
                    .getResultList();
        for (Prestito prestito : p) {
            System.out.println(p);
        }
    }

    public void delete(long id) {
        try {
            em.getTransaction().begin();
            Prestito p = em.find(Prestito.class, id);
            if (p != null) {
                em.remove(p);
                em.getTransaction().commit();
                logInfo("Prestito eliminato con successo");
            } else {
                logInfo("Prestito non trovato");
            }
        } catch (Exception e) {
            rollbackAndLogError("Prestito non eliminato", e);
        }
    }

    public void scaduti(){
        List<Prestito> p = em.createQuery("SELECT p FROM Prestito p WHERE p.scadenza < CURRENT_DATE", Prestito.class)
               .getResultList();
        for (Prestito prestito : p) {
            System.out.println(p);
        }
    }
    private void rollbackAndLogError(String message, Exception e) {
        em.getTransaction().rollback();
        logError(message, e);
    }

    private void logInfo(String message) {
        System.out.println(message);
    }

    private void logError(String message, Exception e) {
        System.err.println(message);
        e.printStackTrace();
    }
}

