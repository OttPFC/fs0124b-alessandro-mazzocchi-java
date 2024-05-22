package com.progetto.M2S1G5PROGETTO.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Email;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="utente")
@Builder(setterPrefix = "with")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(min = 3, max = 50)
    private String username;

    @Length(min = 3, max = 100)
    private String nomeCompleto;

    @Email
    private String email;

    @OneToMany(mappedBy = "utente", fetch = FetchType.LAZY)
    private List<Prenotazioni> prenotazioni;
}
