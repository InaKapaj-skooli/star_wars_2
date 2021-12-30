package com.example.service.service;

import com.example.service.entity.Flight;
import com.example.service.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight update(Long id, Flight flight) {
        if (flight.getId() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Flight Id should not be provided");
        Optional<Flight> existingFlight = flightRepository.findById(id);
        if (existingFlight.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight not found");

        flight.setId(id);
        return flightRepository.save(flight);
    }

    //soft delete
    public Flight delete(Long id, Flight flight) {
        Optional<Flight> flightDeleted = flightRepository.findById(id);
        if (flightDeleted.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight not found");

        flight.setDeleted(true);
        return flightRepository.save(flight);
    }
}
