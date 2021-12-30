package com.example.web.controller;

import com.example.service.entity.Flight;
import com.example.service.mapper.FlightMapper;
import com.example.service.model.FlightDto;
import com.example.service.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @PutMapping(value = "/{id}")
    public ResponseEntity<FlightDto> save(@PathVariable Long id, @RequestBody FlightDto flightDto) {
        Flight flight = FlightMapper.fromFlightDto(flightDto);
        Flight savedFlight = flightService.update(id, flight);

        return ResponseEntity.ok(FlightMapper.fromFlight(savedFlight));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FlightDto> update(@PathVariable Long id, @RequestBody FlightDto flightDto) {
        Flight flight = FlightMapper.fromFlightDto(flightDto);
        Flight updatedFlight = flightService.save(flight);

        return ResponseEntity.ok(FlightMapper.fromFlight(updatedFlight));
    }
}
