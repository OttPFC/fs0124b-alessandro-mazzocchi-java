package org.example.service;
import org.slf4j.Logger;
import org.example.entities.Biblioteca;
import org.example.entities.Libri;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileBiblioService implements BiblioService {

    private static final Logger logger = LoggerFactory.getLogger(FileBiblioService.class);
    private static final String saved = "./savedBiblio.csv";

    private final ArrayList<Biblioteca> biblio = new ArrayList<>();

    @Override
    public void addBooks(Biblioteca books) {
        biblio.add(books);
        save();
    }


    @Override
    public void removeByISBN(long isbn) {
        boolean removed = biblio.removeIf(book -> book.getIsbn() == isbn);
        if (removed) {
            System.out.println("Libro con ISBN " + isbn + " rimosso con successo.");
        } else {
            System.out.println("Libro con ISBN " + isbn + " non trovato.");
        }
    }

    @Override
    public List<Biblioteca> findByISBN(long isbn) {
        return biblio.stream()
                .filter(book -> book.getIsbn() == isbn)
                .collect(Collectors.toList());
    }

    @Override
    public List<Biblioteca> findByYear(int anno) {
        return biblio.stream()
                .filter(book -> book.getAnno() == anno)
                .collect(Collectors.toList());
    }

    @Override
    public List<Biblioteca> findByAuthor(String author) {
        return biblio.stream()
                .filter(book -> book instanceof Libri && ((Libri) book).getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Biblioteca> getAllBooks() {
        return new ArrayList<>(biblio);
    }

    @Override
    public void save() {
        try (FileOutputStream fileOut = new FileOutputStream(saved)) {
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            for (Biblioteca publication : biblio) {
                objectOut.writeObject(publication);
            }
            objectOut.close(); // Chiudi ObjectOutputStream dopo aver salvato tutti gli oggetti
            logger.info("Biblioteca salvata con successo.");
        } catch (IOException e) {
            logger.error("Errore durante il salvataggio della Biblioteca.", e);
        }
    }

    @Override
    public void load() {
        try (FileInputStream fileIn = new FileInputStream(saved);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            while (true) {
                try {
                    Biblioteca publication = (Biblioteca) objectIn.readObject();
                    biblio.add(publication);
                } catch (EOFException e) {
                    // Fine del file raggiunta, termina il loop
                    break;
                } catch (ClassNotFoundException e) {
                    logger.error("Classe non trovata durante il caricamento della Biblioteca.", e);
                }
            }
            logger.info("Biblioteca caricata con successo.");
        } catch (IOException e) {
            logger.error("Errore durante il caricamento della Biblioteca.", e);
        }
    }
}
