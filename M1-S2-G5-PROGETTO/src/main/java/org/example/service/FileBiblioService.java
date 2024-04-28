package org.example.service;
import org.apache.commons.io.FileUtils;
import org.example.entities.Period;
import org.example.entities.Riviste;
import org.slf4j.Logger;
import org.example.entities.Biblioteca;
import org.example.entities.Libri;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileBiblioService implements BiblioService {

    private static final Logger logger = LoggerFactory.getLogger(FileBiblioService.class);
    private static final String saved = "./savedBiblio.csv";

    private final ArrayList<Biblioteca> biblio = new ArrayList<>();

    public FileBiblioService(){
        carica();
    }

    @Override
    public void addBooks(Biblioteca books) {
        biblio.add(books);
        salva();
    }


    @Override
    public void removeByIsbn(long isbn) {
        boolean removed = biblio.removeIf(book -> book.getIsbn() == isbn);
        if (removed) {
            System.out.println("Libro con ISBN " + isbn + " rimosso con successo.");
            salva();
        } else {
            System.out.println("Libro con ISBN " + isbn + " non trovato.");
        }
    }

    @Override
    public List<Biblioteca> findByIsbn(long isbn) {
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
    public void salva() {
        File bib = new File(saved);
        try {
            List<String> allLines = new ArrayList<>();
            for (Biblioteca p : biblio) {
                List<String> list = new ArrayList<>();
                list.add(p.getClass().getSimpleName());
                list.add(String.valueOf(p.getIsbn()));
                list.add(p.getTitle());
                list.add(String.valueOf(p.getAnno()));
                list.add(String.valueOf(p.getPages()));
                if (p instanceof Libri) {
                    Libri l = (Libri) p;
                    list.add(l.getAuthor());
                    list.add(l.getGen());
                } else if (p instanceof Riviste) {
                    Riviste r = (Riviste) p;
                    list.add(r.getPeriod().toString());
                }
                allLines.add(String.join(",", list));
            }
            FileUtils.writeLines(bib, StandardCharsets.ISO_8859_1.name(), allLines, true);
        } catch (IOException e) {
            logger.error("Errore durante il salvataggio", e);
        }
    }


    @Override
    public void carica() {
        File bib = new File(saved);
        //se il file non esiste termino il caricamento
        if (!bib.exists()) return;
        try {
            //puliscvo il vecchio file prima di riscrivere nuovamente
            biblio.clear();

            List<String> files = FileUtils.readLines(bib, StandardCharsets.ISO_8859_1);
            for (String a : files) {
                String[] space = a.split(",");
                String type = space[0];
                if ("Libri".equals(type)) {
                    long isbn = Long.parseLong(space[1]);
                    String title = space[2];
                    int year = Integer.parseInt(space[3]);
                    int pages = Integer.parseInt(space[4]);
                    String author = space[5];
                    String genre = space[6];
                    Libri book = new Libri(isbn, title, year, pages, author, genre);
                    biblio.add(book);
                } else if ("Riviste".equals(type)) {
                    long isbn = Long.parseLong(space[1]);
                    String title = space[2];
                    int anno = Integer.parseInt(space[3]);
                    int pages = Integer.parseInt(space[4]);
                    Period period = Period.valueOf(space[5]);
                    Riviste rivista = new Riviste(isbn, title, anno, pages, period);
                    biblio.add(rivista);
                }
            }
            logger.info("Biblioteca caricata con successo.");
        } catch (IOException e) {
            logger.error("Errore durante il caricamento della Biblioteca.", e);
        }
    }

}

