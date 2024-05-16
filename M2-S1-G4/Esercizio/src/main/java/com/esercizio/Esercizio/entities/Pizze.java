package com.esercizio.Esercizio.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pizze")
@Builder(setterPrefix = "with")
public class Pizze {

    @Id
    private Integer id;

    private String name;


}
