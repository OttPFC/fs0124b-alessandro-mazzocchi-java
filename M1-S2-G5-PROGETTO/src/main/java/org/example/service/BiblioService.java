package org.example.service;

import org.example.entities.Biblioteca;

import java.util.List;

public interface BiblioService {

    void addBooks(Biblioteca books);

    void removeByISBN(long isbn);

    List<Biblioteca> findByISBN(long isbn);

    List<Biblioteca> findByYear(int anno);

    List<Biblioteca> findByAuthor(String author);

    List<Biblioteca> getAllBooks();

    void save();

    void load();

}
