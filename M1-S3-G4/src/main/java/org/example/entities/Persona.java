package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persone")
public class Persona {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String surname;
    private String email;
    private LocalDate dataDiNascita;

    @Enumerated(EnumType.STRING)
    private Genere genere;

    @OneToMany(mappedBy = "persona")
    private final List<Partecipazioni> partecipazione = new ArrayList<>();

    public Persona(){

    }

    public Persona(String name, String surname, String email, LocalDate dataDiNascita, Genere genere) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.genere = genere;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Genere getSesso() {
        return genere;
    }

    public void setSesso(Genere genere) {
        this.genere = genere;
    }

    public List<Partecipazioni> getPartecipazione() {
        return partecipazione;
    }

    @Override
    public String toString() {
        return "Persona:" +
                "\nid=" + id +
                "\nname='" + name + '\'' +
                "\nsurname='" + surname + '\'' +
                "\nemail='" + email + '\'' +
                "\ndataDiNascita=" + dataDiNascita +
                "\ngenere=" + genere +
                "\npartecipazione=" + partecipazione;
    }
}
