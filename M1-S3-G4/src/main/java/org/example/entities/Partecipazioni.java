package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "partecipazioni")
public class Partecipazioni {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @Enumerated(EnumType.STRING)
    private StatoConferma statoConferma;

    public Partecipazioni(){}

    public Partecipazioni(Persona persona, Evento evento, StatoConferma statoConferma) {
        this.persona = persona;
        this.evento = evento;
        this.statoConferma = statoConferma;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public StatoConferma getStatoConferma() {
        return statoConferma;
    }

    public void setStatoConferma(StatoConferma statoConferma) {
        this.statoConferma = statoConferma;
    }

    @Override
    public String toString() {
        return "Partecipazioni" +
                "\nid=" + id +
                "\npersona=" + persona +
                "\nevento=" + evento +
                "\nstatoConferma=" + statoConferma;
    }
}
