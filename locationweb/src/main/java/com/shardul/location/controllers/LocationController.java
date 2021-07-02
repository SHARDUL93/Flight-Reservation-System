package com.shardul.location.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) {
		List<Location> allLocations = service.getAllLocations();
		modelMap.addAttribute("locations", allLocations);
		return "displayLocations";
	}

	@RequestMapping("deleteLocation")
	public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
		Location locationById = service.getLocationById(id);
		service.deleteLocation(locationById);
		List<Location> allLocations = service.getAllLocations();
		modelMap.addAttribute("locations", allLocations);
		return "displayLocations";
	}

	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
		Location locationById = service.getLocationById(id);
		modelMap.addAttribute("location", locationById);
		return "updateLocation";
	}

	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		service.updateLocation(location);
		List<Location> allLocations = service.getAllLocations();
		modelMap.addAttribute("locations", allLocations);
		return "displayLocations";

	}

}
