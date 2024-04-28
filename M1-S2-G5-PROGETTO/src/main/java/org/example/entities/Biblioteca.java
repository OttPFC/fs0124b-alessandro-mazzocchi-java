package org.example.entities;

public abstract class Biblioteca {
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

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public void setPages(int pages) {
        this.pages = pages;
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
        return "Libro: " + title + "\nAuthor: " + "\nYear: " + anno + "\nPages: " + pages;
    }
}
