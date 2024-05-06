package org.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "libri")
public class Libri extends Biblioteca {

    @Column(name = "autore")
    private String autore;
    @Column(name = "genere")
    private String genere;



    public Libri(long isbn, String titolo, int annoPublicazione, int pagine, String autore, String genere) {
        super(isbn, titolo, annoPublicazione, pagine);
        this.autore = autore;
        this.genere = genere;
    }
    public Libri() {};


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
