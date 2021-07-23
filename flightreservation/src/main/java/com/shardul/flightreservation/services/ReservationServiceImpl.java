package com.shardul.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shardul.flightreservation.dto.ReservationRequest;
import com.shardul.flightreservation.entities.Flight;
import com.shardul.flightreservation.entities.Passenger;
import com.shardul.flightreservation.entities.Reservation;
import com.shardul.flightreservation.repos.FlightRepository;
import com.shardul.flightreservation.repos.PassengerRepository;
import com.shardul.flightreservation.repos.ReservationRepository;
import com.shardul.flightreservation.util.EmailUtil;
import com.shardul.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	PassengerRepository passengerRepository;

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	PDFGenerator pdfGenerator;

	@Autowired
	EmailUtil emailUtil;

	@Override
	public Reservation bookFlight(ReservationRequest request) {

		Long flightId = request.getFlightId();
		Flight flight = flightRepository.findById(flightId).get();

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		Passenger savedPasseanger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPasseanger);
		reservation.setCheckedIn(false);

		Reservation savedReservation = reservationRepository.save(reservation);

		String filePath = "C:/Users/Dell/Documents/workspace-sts-3.9.12.RELEASE/flightreservation/reservations/reservation"
				+ savedReservation.getId() + ".pdf";
		pdfGenerator.generateItinerary(savedReservation, filePath);

		emailUtil.sentItineary(passenger.getEmail(), filePath);

		return savedReservation;
	}

}
