package com.gestioneeventi.M2_S3_G5_PROGETTO.datalayer.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "event")
public class Event extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_seq")
    @SequenceGenerator(name = "event_seq", sequenceName = "event_seq")
    @EqualsAndHashCode.Include
    private long id;

    @Column(length = 80, nullable = false)
    private String name;

    @Column(length = 1024, nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Users author;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateTime;

    @Column(length = 255)
    private String location;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings;
}
