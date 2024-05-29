package org.example.composite;

import java.util.List;

public class Libro extends BaseEntity {
    private String titolo;
    private List<Sezione> capitoli;
    private double prezzo;
    private List<String> autori;

    public Libro(String titolo, List<Sezione> capitoli, double prezzo, List<String> autori) {
        this.titolo = titolo;
        this.capitoli = capitoli;
        this.prezzo = prezzo;
        this.autori = autori;
    }

    public String getTitolo() {
        return titolo;
    }

    public List<Sezione> getCapitoli() {
        return capitoli;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public List<String> getAutori() {
        return autori;
    }

    @Override
    public int getNumeroPagine() {
        return this.capitoli.stream().mapToInt(Sezione::getNumeroPagine).sum();
    }

    @Override
    public void stampa() {
        System.out.println("Titolo libro: " + this.getTitolo());
        this.capitoli.forEach(Sezione::stampa);
    }
}
