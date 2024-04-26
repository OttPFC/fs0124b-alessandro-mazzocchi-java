package org.example.entities;

import org.example.service.createBook;

import java.util.Random;

public class Libri implements createBook {

    private String author;
    private String gen;
    private long isbn;
    private String title;
    private int anno;
    private int pages;



    public Libri(String title, int anno, int pages, String author, String gen) {
        Random rndm = new Random();
        this.isbn = rndm.nextLong();
        this.title = title;
        this.anno = anno;
        this.pages = pages;
        this.author = author;
        this.gen = gen;
    }
    public String getAuthor() {
        return author;
    }
    public String getGen() {
        return gen;
    }

    public long getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getAnno() {
        return anno;
    }

    public int getPages() {
        return pages;
    }
    public String toString() {
        return "Libro: " + title + "\nAuthor: " + author + "\nYear: " + anno + "\nPages: " + pages;
    }

    @Override
    public Libri create() {
        Libri l = new Libri(title, anno, pages, author, gen);
        book.add(l);
        return l;

    }
}
