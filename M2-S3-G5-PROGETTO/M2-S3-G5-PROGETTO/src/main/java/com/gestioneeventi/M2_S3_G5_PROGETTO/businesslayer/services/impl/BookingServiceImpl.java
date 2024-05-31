package com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.impl;

import com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.BookingService;
import com.gestioneeventi.M2_S3_G5_PROGETTO.datalayer.entities.Booking;
import com.gestioneeventi.M2_S3_G5_PROGETTO.datalayer.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<Booking> findAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Optional<Booking> findBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
