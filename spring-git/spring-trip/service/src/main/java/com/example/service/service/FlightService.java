package com.example.service.service;

import com.example.service.entity.Flight;
import org.springframework.stereotype.Service;

@Service
public interface FlightService {

    Flight save(Flight flight);

    Flight update(Long id, Flight flight);

    Flight delete(Long id, Flight flight);
}
