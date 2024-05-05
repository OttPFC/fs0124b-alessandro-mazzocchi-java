package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import org.example.entities.Biblioteca;

import java.time.LocalDate;
import java.util.List;

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
        }
    }

    public Biblioteca findByIsbn(long isbn) {
        try {
            System.out.println("Elemento trovato");
            return em.createQuery("SELECT b FROM Biblioteca b WHERE b.isbn = :isbn", Biblioteca.class)
                    .setParameter("isbn", isbn)
                    .getSingleResult();

        } catch (NoResultException e) {
            System.out.println("nullo");
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Errore durante la ricerca della biblioteca per ISBN: " + isbn, e);
        }
    }

    public List<Biblioteca> findByYear(int year) {
        return em.createQuery("SELECT i FROM Biblioteca i WHERE i.annoPublicazione = :year", Biblioteca.class)
                .setParameter("publicationYear", year)
                .getResultList();
    }




    public void delete(long isbn) {
        try {
            em.getTransaction().begin();
            Biblioteca b = findByIsbn(isbn);
            if (b != null) {
                em.remove(b);
                em.getTransaction().commit();
                System.out.println("Biblioteca eliminato");
            } else System.out.println("Biblioteca non trovato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
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

