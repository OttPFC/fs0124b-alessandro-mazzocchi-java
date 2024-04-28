package org.example.service;

import org.example.entities.Biblioteca;

import java.util.List;

public interface BiblioService {

    void addBooks(Biblioteca books);

    void removeByIsbn(long isbn);

    List<Biblioteca> findByIsbn(long isbn);

    List<Biblioteca> findByYear(int anno);

    List<Biblioteca> findByAuthor(String author);

    List<Biblioteca> getAllBooks();

    void salva();

    void carica();

}
