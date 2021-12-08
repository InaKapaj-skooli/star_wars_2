package com.example.springtripweb.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

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

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    //@JoinColumn(name = "trip_id")
    private Trip tripStatus;
}
