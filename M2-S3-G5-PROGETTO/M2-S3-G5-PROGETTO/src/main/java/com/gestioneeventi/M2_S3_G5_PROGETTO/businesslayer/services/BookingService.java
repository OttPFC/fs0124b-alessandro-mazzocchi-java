package com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services;

import com.gestioneeventi.M2_S3_G5_PROGETTO.datalayer.entities.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    List<Booking> findAllBookings();
    Optional<Booking> findBookingById(Long id);
    Booking saveBooking(Booking booking);
    void deleteBooking(Long id);
}
