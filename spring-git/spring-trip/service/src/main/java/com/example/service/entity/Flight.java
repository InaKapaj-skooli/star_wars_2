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
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromFlight;

    private String toFlight;

    private Date departureDate;

    private Date arrivalDate;

    @OneToMany(mappedBy = "flight")
    private Set<UserEntity> user;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    private Trip trips;

    private boolean deleted = Boolean.FALSE;
}
