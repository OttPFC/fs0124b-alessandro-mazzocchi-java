package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.entities.Biblioteca;

public class BibliotecaDAO {

    private EntityManager em;

    public BibliotecaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Biblioteca biblio) {
        try {
            em.getTransaction().begin();
            em.persist(biblio);
            em.getTransaction().commit();
            logInfo("Salvataggio avvenuto con successo");
        } catch (Exception e) {
            rollbackAndLogError("Salvataggio non riuscito", e);
        } finally {
            closeEntityManager();
        }
    }

    public Biblioteca findByTitle(String title) {
        try {
            return em.find(Biblioteca.class, title);
        } finally {
            closeEntityManager();
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

    private void closeEntityManager() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}

