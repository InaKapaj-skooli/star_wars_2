package com.example.service.mapper;

import com.example.service.entity.Trip;
import com.example.service.model.TripDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TripMapper {

    public TripDto fromTrip() {
        return fromTrip();
    }

    public TripDto fromTrip(Trip trip) {
        TripDto tripDto = new TripDto();
        tripDto.setId(trip.getId());
        tripDto.setTripDescription(trip.getTripDescription());
        tripDto.setFrom(trip.getFromTrip());
        tripDto.setTo(trip.getToTrip());
        tripDto.setDepartureDate(trip.getDepartureDate());
        tripDto.setArrivalDate(trip.getArrivalDate());
        return tripDto;
    }

    public Trip fromTripDto(TripDto tripDto) {
        Trip trip = new Trip();
        trip.setId(tripDto.getId());
        trip.setTripDescription(tripDto.getTripDescription());
        trip.setFromTrip(tripDto.getFrom());
        trip.setToTrip(tripDto.getTo());
        trip.setDepartureDate(tripDto.getDepartureDate());
        trip.setArrivalDate(tripDto.getArrivalDate());
        return trip;
    }
}
