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
@Table(name = "trip_reason")
public class TripReason {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reason;

    @OneToMany(mappedBy = "tripReason", cascade = CascadeType.ALL)
    private Set<Trip> tripReason;

    public void setTripReason(String reason) {
    }
}
