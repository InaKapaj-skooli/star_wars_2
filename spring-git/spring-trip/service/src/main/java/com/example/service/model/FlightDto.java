package com.example.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class FlightDto {

    private Long id;

    private String from;

    private String to;

    private Date departureDate;

    private Date arrivalDate;
}
