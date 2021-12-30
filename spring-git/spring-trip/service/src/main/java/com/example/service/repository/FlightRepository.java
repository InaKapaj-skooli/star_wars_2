package com.example.service.repository;

import com.example.service.entity.Flight;
import com.example.service.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    Flight save(Flight flight);
}
