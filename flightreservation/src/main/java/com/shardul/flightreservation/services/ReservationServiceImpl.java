package com.shardul.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Value("${com.shardul.flightreservation.itinerary.dirpath}")
	private String ITINERARY_DIR;
	
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		LOGGER.info("Inside bookFlight()");

		Long flightId = request.getFlightId();
		LOGGER.info("Fetching flight for flight id: "+flightId);
		Flight flight = flightRepository.findById(flightId).get();

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		LOGGER.info("Saving the passenger :"+passenger);
		Passenger savedPasseanger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPasseanger);
		reservation.setCheckedIn(false);
		LOGGER.info("Saving the reservation :"+reservation);
		Reservation savedReservation = reservationRepository.save(reservation);

		String filePath = ITINERARY_DIR + savedReservation.getId() + ".pdf";
		LOGGER.info("Generating the itinerary");
		pdfGenerator.generateItinerary(savedReservation, filePath);

		LOGGER.info("Sending the itinerary");
		emailUtil.sentItineary(passenger.getEmail(), filePath);

		return savedReservation;
	}

}
