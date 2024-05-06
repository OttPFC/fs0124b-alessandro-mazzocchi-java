package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestiti")
public class Prestito extends BaseEntity{

    private LocalDate inizioPrestito;

    private LocalDate restituzionePrevista;
    private LocalDate restituzione;

    @ManyToOne
    @JoinColumn(name = "biblioteca_id")
    private Biblioteca biblioteca;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "tessera_utente")
    private Utente tessera;

    public Prestito(){}

    public Prestito(Utente utente, Biblioteca biblioteca, LocalDate inizioPrestito, LocalDate restituzione) {
        this.utente = utente;
        this.biblioteca = biblioteca;
        this.inizioPrestito = inizioPrestito;
        this.restituzionePrevista = getRestituzionePrevista();
        this.restituzione = restituzione;
    }

    public LocalDate getInizioPrestito() {
        return inizioPrestito;
    }

    public void setInizioPrestito(LocalDate inizioPrestito) {
        this.inizioPrestito = inizioPrestito;
    }

    public LocalDate getRestituzionePrevista() {
        return this.inizioPrestito.plusDays(30);
    }


    public void setRestituzionePrevista(LocalDate restituzionePrevista) {
        this.restituzionePrevista = restituzionePrevista;
    }

    public LocalDate getRestituzione() {
        return restituzione;
    }

    public void setRestituzione(LocalDate restituzione) {
        this.restituzione = restituzione;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
    public String toString() {
        return "Prestito{" +
                "id=" + super.getId()+
                ", inizioPrestito=" + inizioPrestito +
                ", restituzionePrevista=" + restituzionePrevista +
                ", restituzione=" + restituzione +
                ", libro="+ this.biblioteca +
                ", utente=" + this.utente +
                '}';
    }
}
