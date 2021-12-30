package com.example.service.service;

import com.example.service.entity.Trip;
import com.example.service.entity.TripReason;
import com.example.service.entity.TripStatus;
import com.example.service.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepository;

    public Trip save(Trip trip) {
        return tripRepository.save(trip);
    }

    public Trip update(Long id, Trip trip) {
        if (trip.getId() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Trip Id should not be provided");
        Optional<Trip> existingTrip = tripRepository.findById(id);
        if (existingTrip.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trip not found");

        trip.setId(id);
        return tripRepository.save(trip);
    }

    public Trip reason(Long id, TripReason trip) {
        Optional<Trip> tripEntity = tripRepository.findById(id);
        if (tripEntity.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trip not found");

        trip.setTripReason("WORK");
        return tripRepository.saveReason(trip);
    }

    public Trip status(Long id, TripStatus trip) {
        Optional<Trip> tripEntity = tripRepository.findById(id);
        if (tripEntity.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trip not found");

        trip.setTripStatus("CREATED");
        return tripRepository.saveStatus(trip);
    }

    //soft delete
    public Trip delete(Long id, Trip trip) {
        Optional<Trip> tripDeleted = tripRepository.findById(id);
        if (tripDeleted.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trip not found");

        trip.setDeleted(true);
        return tripRepository.save(trip);
    }
}
