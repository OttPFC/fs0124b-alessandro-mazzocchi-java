package org.example.entities;

public class Riviste extends Biblioteca{
    private long isbn;
    private String title;
    private int anno;
    private int pages;
    private String[] period = new String[]{"SETTIMANALE", "MENSILE", "SEMESTRALE"};

    public Riviste(long isbn, String title, int anno, int pages, String[] period) {
        this.isbn = isbn;
        this.title = title;
        this.anno = anno;
        this.pages = pages;
        this.period = period;
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

    public String[] getPeriod() {
        return period;
    }

    public String toString() {return "Rivista: " + title+ "\nYear: " + anno+ "\nPages: " + pages+"\nPeriod: " + period;}
}
