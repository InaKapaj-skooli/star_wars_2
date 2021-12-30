package com.example.service.mapper;

import com.example.service.entity.Flight;
import com.example.service.model.FlightDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FlightMapper {

    public FlightDto fromFlight() {
        return fromFlight();
    }

    public FlightDto fromFlight(Flight flight) {
        FlightDto flightDto = new FlightDto();
        flightDto.setId(flight.getId());
        flightDto.setFrom(flight.getFromFlight());
        flightDto.setTo(flight.getToFlight());
        flightDto.setDepartureDate(flight.getDepartureDate());
        flightDto.setArrivalDate(flight.getArrivalDate());
        return flightDto;
    }

    public Flight fromFlightDto(FlightDto flightDto) {
        Flight flight = new Flight();
        flight.setId(flightDto.getId());
        flight.setFromFlight(flightDto.getFrom());
        flight.setToFlight(flightDto.getTo());
        flight.setDepartureDate(flightDto.getDepartureDate());
        flight.setArrivalDate(flightDto.getArrivalDate());
        return flight;
    }
}
