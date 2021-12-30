package com.example.service.service;

import com.example.service.entity.Trip;
import com.example.service.entity.TripReason;
import com.example.service.entity.TripStatus;
import org.springframework.stereotype.Service;

@Service
public interface TripService {

    Trip save(Trip trip);

    Trip update(Long id, Trip trip);

    Trip delete(Long id, Trip trip);

    Trip reason(Long id, TripReason reason);

    Trip status(Long id, TripStatus status);
}
