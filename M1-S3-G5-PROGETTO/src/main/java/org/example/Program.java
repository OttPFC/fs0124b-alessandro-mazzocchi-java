package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.BibliotecaDAO;
import org.example.dao.PrestitoDAO;
import org.example.dao.UtenteDAO;
import org.example.entities.*;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Program {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        BibliotecaDAO biblioDao = new BibliotecaDAO(em);
        PrestitoDAO prestDao = new PrestitoDAO(em);
        UtenteDAO utDao = new UtenteDAO(em);
        LocalDate dataLibro = LocalDate.of(2023, 4, 20);
        LocalDate restituzione = LocalDate.of(2024, 4, 20);
        LocalDate dataNascita = LocalDate.of(2083, 4, 20);

        Libri lib = new Libri(123456,"La valle incantata",dataLibro,256,"Mauro Lizori","Fantasy");
        Libri lib2 = new Libri(14523456,"La valle incantatissima",dataLibro,2556,"Maurizio Lipari","Fantasy");
        Riviste riv = new Riviste(4558692,"Come sopravvivere a un bootcamp",LocalDate.now(),20, Periodicita.SEMESTRALE);
        Riviste riv2 = new Riviste(455889692,"Come sopravvivere a un bootcamp pt.2",LocalDate.now(),25, Periodicita.SEMESTRALE);
        Utente mario = new Utente("Mario","Maria",dataNascita);
        Prestito prestito = new Prestito(mario,lib,LocalDate.now(),restituzione);

        biblioDao.save(lib);
        biblioDao.save(lib2);
        biblioDao.save(riv);
        biblioDao.save(riv2);
        utDao.save(mario);
        prestDao.save(prestito);

        em.close();
        emf.close();
    }
}