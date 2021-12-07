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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String password;

    private String email;

    @ManyToMany(mappedBy = "role")
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "trip")
    private Set<Trip> trip = new HashSet<>();

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private Set<Flight> flights = new HashSet<>();
}
