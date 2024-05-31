package com.gestioneeventi.M2_S3_G5_PROGETTO.datalayer.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "booking")
public class Booking extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_seq")
    @SequenceGenerator(name = "booking_seq", sequenceName = "booking_seq")
    @EqualsAndHashCode.Include
    private long id;
    @Column(length = 1024, nullable = false)
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime publishedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
