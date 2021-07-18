package com.shardul.flightreservation.services;

import org.springframework.stereotype.Service;

import com.shardul.flightreservation.dto.ReservationRequest;
import com.shardul.flightreservation.entities.Reservation;

@Service
public interface ReservationService {

	public Reservation bookFlight(ReservationRequest request);
}
