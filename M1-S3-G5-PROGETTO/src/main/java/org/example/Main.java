package org.example;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.BibliotecaDAO;
import org.example.dao.PrestitoDAO;
import org.example.dao.UtenteDAO;
import org.example.entities.*;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("esercizioBiblioteca");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker(Locale.ITALY);
        BibliotecaDAO biblioDao = new BibliotecaDAO(em);
        PrestitoDAO prestDao = new PrestitoDAO(em);
        UtenteDAO utDao = new UtenteDAO(em);
        Random rndm = new Random();

        for (int i = 0; i < 10; i++) {
            int year = rndm.nextInt(2008 - 1930 + 1) + 1930;
            int month = rndm.nextInt(12) + 1;
            int day = rndm.nextInt(28) + 1;
            LocalDate birthDate = LocalDate.of(year, month, day);
            Utente utente = new Utente(faker.name().firstName(), faker.name().lastName(), birthDate);
            //utDao.save(utente);
        }

        for (int i = 0; i < 30; i++) {
            int year = rndm.nextInt(2024 - 1400 + 1) + 1930;
            Libri libro = new Libri(i, faker.book().title(), year, faker.number().numberBetween(100, 1000), faker.name().fullName(), faker.book().genre());
            //biblioDao.save(libro);
        }

        for (int i = 0; i < 30; i++) {
            int year = rndm.nextInt(2024 - 1920 + 1) + 1930;
            int randomIndex = ThreadLocalRandom.current().nextInt(Periodicita.values().length);
            Periodicita randomPeriodicita = Periodicita.values()[randomIndex];
            Riviste riviste = new Riviste(i, faker.book().title(), year, faker.number().numberBetween(100, 1000), randomPeriodicita);
                    //biblioDao.save(riviste);
        }


        LocalDate restituzione = LocalDate.of(2024, 4, 20);
        LocalDate dataNascita = LocalDate.of(2083, 4, 20);

        Libri lib = new Libri(123456,"La valle incantata",2023,256,"Mauro Lizori","Fantasy");
        Libri lib2 = new Libri(145234,"La valle incantatissima",2002,2556,"Maurizio Lipari","Fantasy");
        Riviste riv = new Riviste(8692,"Come sopravvivere a un bootcamp",2024,20, Periodicita.SEMESTRALE);
        Riviste riv2 = new Riviste(49692,"Come sopravvivere a un bootcamp pt.2",2024,25, Periodicita.SEMESTRALE);
        Utente mario = new Utente("Mario","Maria",dataNascita);


        Prestito prestito = new Prestito(mario,lib,LocalDate.now(),restituzione);
        Prestito prestito2 = new Prestito(mario,lib2,LocalDate.now(),restituzione);
        Prestito prestito3 = new Prestito(mario,riv,LocalDate.now(),restituzione);
        Prestito prestito4 = new Prestito(mario,riv2,LocalDate.now(),restituzione);

        System.out.println(prestito);

        //biblioDao.findByIsbn(20);
        //biblioDao.delete(20);
        biblioDao.findByYear(2024);
        em.close();
        emf.close();
    }
}