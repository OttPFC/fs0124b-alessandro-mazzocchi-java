package com.progetto.M2S1G5PROGETTO.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "postazione")
@Builder(setterPrefix = "with")
public class Postazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private long codiceUnivoco;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    private Integer maxPax;

    @ManyToOne
    private Edificio edificio;

}
