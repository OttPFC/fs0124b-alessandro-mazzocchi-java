package com.esercizio.Esercizio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.esercizio.Esercizio.entities.Pizza;

import java.util.List;

public interface ItemsRepository extends JpaRepository<Pizza,Integer> {

    List<Pizza> findAll(String pizza);

}
