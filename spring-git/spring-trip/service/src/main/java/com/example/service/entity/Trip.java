package com.example.service.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private TripReason tripReason;

    private String tripDescription;

    private String fromTrip;

    private String toTrip;

    private Date departureDate;

    private Date arrivalDate;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private TripStatus tripStatus;

    @OneToMany(mappedBy = "trips", cascade = CascadeType.ALL)
    private Set<Flight> flights;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private Set<UserEntity> user;

    private boolean deleted = Boolean.FALSE;
}
