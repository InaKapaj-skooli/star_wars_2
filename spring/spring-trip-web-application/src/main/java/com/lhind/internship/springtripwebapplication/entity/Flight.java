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
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String from;

    private String to;

    private String departureDate;

    private String arrivalDate;

    @ManyToMany(mappedBy = "flight")
    private Set<User> users = new HashSet<>();

}
