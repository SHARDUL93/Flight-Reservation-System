package com.shardul.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shardul.flightreservation.dto.ReservationRequest;
import com.shardul.flightreservation.entities.Flight;
import com.shardul.flightreservation.entities.Reservation;
import com.shardul.flightreservation.repos.FlightRepository;
import com.shardul.flightreservation.services.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	FlightRepository flightRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

	@Autowired
	ReservationService reservationService;

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		
		LOGGER.info("Inside showCompleteReservation() invoked with flightId: "+flightId);
		Flight flight = flightRepository.findById(flightId).get();
		modelMap.addAttribute("flight", flight);
		LOGGER.info("Flight is "+flight);
		return "completeResevation";

	}

	@RequestMapping(value = "/completeResevation", method = RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		
		LOGGER.info("Inside completeReservation()  "+request);
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation created successfully and the id is :" + reservation.getId());
		LOGGER.info("Reservation created successfully and the id is :"+reservation.getId());
		return "reservationConfirmation";
	}

}
