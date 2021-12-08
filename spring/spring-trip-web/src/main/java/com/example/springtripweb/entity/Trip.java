package com.example.springtripweb.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
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

    @OneToMany(mappedBy = "tripReason", cascade = CascadeType.ALL)
    private Set<TripReason> tripReasons;

    private String tripDescription;

    private String from;

    private String to;

    private String departureDate;

    private String arrivalDate;

    @OneToMany(mappedBy = "tripStatus", cascade = CascadeType.ALL)
    private Set<TripStatus> tripStatuses;

    @OneToMany(mappedBy = "trips", cascade = CascadeType.ALL)
    private Set<Flight> flights;

    @OneToMany(mappedBy = "trip",cascade = CascadeType.ALL)
    private Set<User> user;
}
