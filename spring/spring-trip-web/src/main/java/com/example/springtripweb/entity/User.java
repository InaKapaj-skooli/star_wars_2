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
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String password;

    private String email;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    //@JoinColumn(name = "trip_id")
    private Trip trip;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    //@JoinColumn(name = "flight_id")
    private Flight flight;
}
