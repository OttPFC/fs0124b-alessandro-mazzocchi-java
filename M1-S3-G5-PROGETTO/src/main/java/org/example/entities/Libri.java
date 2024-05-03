package org.example.entities;

import java.time.LocalDate;

public class Libri extends Biblioteca {

    private String autore;
    private String genere;


    public Libri() {};

    public Libri(long isbn, String titolo, LocalDate annoPubblicazione, int pagine, String autore, String genere) {
        super(isbn, titolo, annoPubblicazione, pagine);
        this.autore = autore;
        this.genere = genere;
    }


    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString(){
        return super.toString() +
                ", autore='" + autore + '\'' +
                ", genere='" + genere + '\'';
    }
}
