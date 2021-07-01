package com.shardul.location.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shardul.location.entities.Location;
import com.shardul.location.service.LocationService;

@Controller
public class LocationController {

	@Autowired
	LocationService service;

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}

	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		Location saveLocation = service.saveLocation(location);
		String msg = "Location saved with id: " + saveLocation.getId();
		modelMap.addAttribute("msg", msg);
		return "createLocation";
	}

}
