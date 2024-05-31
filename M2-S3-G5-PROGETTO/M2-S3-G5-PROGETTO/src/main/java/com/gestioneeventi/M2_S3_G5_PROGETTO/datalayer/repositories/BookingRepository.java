package com.gestioneeventi.M2_S3_G5_PROGETTO.datalayer.repositories;

import com.gestioneeventi.M2_S3_G5_PROGETTO.datalayer.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    Optional<Booking> findById(Long id);
}