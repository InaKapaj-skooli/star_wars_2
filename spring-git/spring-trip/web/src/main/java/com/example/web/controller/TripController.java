package com.example.web.controller;

import com.example.service.entity.Trip;
import com.example.service.mapper.TripMapper;
import com.example.service.model.TripDto;
import com.example.service.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trips")
public class TripController {

    @Autowired
    TripService tripService;

    @PutMapping(value = "/{id}")
    public ResponseEntity<TripDto> save(@PathVariable Long id, @RequestBody TripDto tripDto) {
        Trip trip = TripMapper.fromTripDto(tripDto);
        Trip savedTrip = tripService.update(id, trip);

        return ResponseEntity.ok(TripMapper.fromTrip(savedTrip));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TripDto> update(@PathVariable Long id, @RequestBody TripDto tripDto) {
        Trip trip = TripMapper.fromTripDto(tripDto);
        Trip updatedTrip = tripService.save(trip);

        return ResponseEntity.ok(TripMapper.fromTrip(updatedTrip));
    }
}
