package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestiti")
public class Prestito {

    @Id
    @GeneratedValue
    private long id;

    private LocalDate inizioPrestito;

    private LocalDate restituzionePrevista;
    private LocalDate restituzione;

    @ManyToOne
    @JoinColumn(name = "libro_isbn")
    private Biblioteca biblioteca;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;



    public Prestito(){}

    public Prestito(Utente utente, Biblioteca biblioteca, LocalDate inizioPrestito, LocalDate restituzione) {

        this.inizioPrestito = inizioPrestito;
        this.restituzionePrevista = getRestituzionePrevista();
        this.restituzione = restituzione;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", inizioPrestito=" + inizioPrestito +
                ", restituzionePrevista=" + restituzionePrevista +
                ", restituzione=" + restituzione +
                ", libro=" + biblioteca +
                ", utente=" + utente +
                '}';
    }
}
