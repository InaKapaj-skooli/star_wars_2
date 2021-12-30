package com.example.service.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "trip_status")
public class TripStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @OneToMany(mappedBy = "tripStatus", cascade = CascadeType.ALL)
    private Set<Trip> tripStatus;

    public void setTripStatus(String status) {
    }
}
