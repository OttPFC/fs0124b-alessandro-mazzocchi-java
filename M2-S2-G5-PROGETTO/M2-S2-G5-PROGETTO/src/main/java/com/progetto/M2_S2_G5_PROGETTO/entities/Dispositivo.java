package com.progetto.M2_S2_G5_PROGETTO.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dispositivo")
@Builder(setterPrefix = "with")
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String nome;
    @NotBlank
    private String tipo;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private Stato stato;

    @NotBlank
    private String image;

    @ManyToOne
    private Dipendente dipendente;
}
