package com.progetto.M2S1G5PROGETTO.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prenotazioni")
public class Prenotazioni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate giornoPrenotazione = LocalDate.now();
    private LocalDate giornoPrenotato;
    private LocalDate giornoScadenza;

    @ManyToOne
    private Edificio edificio;

    @ManyToOne
    private Utente utente;

    @OneToOne
    private Postazione postazione;

    public void calcolaGiornoScadenza() {
        if (giornoPrenotato == null) {
            giornoScadenza = null;
            return;
        }
        giornoScadenza = giornoPrenotato.plusDays(1);
    }
}
