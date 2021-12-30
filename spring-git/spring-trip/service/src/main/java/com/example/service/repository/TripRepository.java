package com.example.service.repository;

import com.example.service.entity.Trip;
import com.example.service.entity.TripReason;
import com.example.service.entity.TripStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    Trip save(Trip trip);

    Trip saveReason(TripReason reason);

    Trip saveStatus(TripStatus status);
}
