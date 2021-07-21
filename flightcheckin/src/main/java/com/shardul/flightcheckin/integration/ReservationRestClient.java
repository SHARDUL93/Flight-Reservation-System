package com.shardul.flightcheckin.integration;

import com.shardul.flightcheckin.integration.dto.Reservation;
import com.shardul.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

	public Reservation findReservation(Long id);

	public Reservation updateReservation(ReservationUpdateRequest request);

}
