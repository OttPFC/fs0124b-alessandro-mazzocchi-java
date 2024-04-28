package org.example.entities;

public class Libri  extends Biblioteca {

    private final String author;
    private final String gen;
    public Libri(long isbn, String title, int anno, int pages, String author,String gen) {
        super(isbn, title, anno, pages);
        this.author = author;
        this.gen = gen;
    }


    public String getAuthor() {
        return author;
    }
    public String getGen() {
        return gen;
    }

    @Override
    public String toString() {
        return
                "\nLibro: " + getTitle() + "\nISBN: " + getIsbn() + "\nAuthor: " +
                        author + "\nYear: " + getAnno() + "\nPages: " + getPages();
    }


}
