package org.example.entities;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

public class Riviste extends Biblioteca {

    @Enumerated(EnumType.STRING)
    private Periodicita periodo;

    public Riviste(){};
    public Riviste(long isbn, String titolo, LocalDate annoPubblicazione, int pagine, Periodicita periodo) {
        super(isbn, titolo, annoPubblicazione, pagine);
        this.periodo = periodo;
    }

    public Periodicita getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodicita periodo) {
        this.periodo = periodo;
    }

    @Override
    public String toString() {
        return "Riviste{" +
                "periodo=" + periodo +
                "} " + super.toString();
    }
}
