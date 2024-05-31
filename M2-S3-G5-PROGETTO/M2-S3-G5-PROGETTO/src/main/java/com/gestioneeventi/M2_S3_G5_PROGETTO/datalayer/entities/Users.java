package com.gestioneeventi.M2_S3_G5_PROGETTO.datalayer.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "users")
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class Users extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    @SequenceGenerator(name = "users_seq", sequenceName = "users_seq")
    private long id;
    @Column(length = 125, unique = true, nullable = false)
    @EqualsAndHashCode.Include
    private String username;
    @Column(length = 125, nullable = false)
    private String password;
    @Column(length = 25)
    @Email
    private String email;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private final List<RoleEntity> roles = new ArrayList<>();

    private String cretedBy;
    private String updatedBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @PrePersist
    protected void onCreate(){
        createdDate = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        updatedDate = new Date();
    }

    private String role;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings;


}
