package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "riviste")
public class Riviste extends Biblioteca {


    @Enumerated(EnumType.STRING)
    @Column(name = "periodo")
    private Periodicita periodo;

    public Riviste(long isbn, String titolo, int annoPubblicazione, int pagine, Periodicita periodo) {
        super(isbn, titolo, annoPubblicazione, pagine);
        this.periodo = periodo;
    }
    public Riviste(){};
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
