package com.esercizio.M2S2G3.repositories;

import com.esercizio.M2S2G3.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorsRepository extends JpaRepository<Author, Integer> {

    Optional<Author> findByEmail(String email);
}
