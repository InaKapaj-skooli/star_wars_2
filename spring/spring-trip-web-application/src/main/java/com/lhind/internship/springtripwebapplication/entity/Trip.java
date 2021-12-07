package com.lhind.internship.springtripwebapplication.entity;

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
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "tripReason", cascade = CascadeType.ALL)
    private Set<TripReason> tripReason;

    private String tripDescription;

    private String from;

    private String to;

    private String departureDate;

    private String arrivalDate;

    @OneToMany(mappedBy = "tripStatus", cascade = CascadeType.ALL)
    private Set<TripStatus> tripStatus = new HashSet<>();

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private Set<Flight> flights = new HashSet<>();
}
