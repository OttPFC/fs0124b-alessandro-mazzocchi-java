package org.example.entities;

public class Biblioteca {
    private long isbn;
    private String title;
    private int anno;
    private int pages;

    public Biblioteca(long isbn, String title, int anno, int pages) {
        this.isbn = isbn;
        this.title = title;
        this.anno = anno;
        this.pages = pages;
    }
}
