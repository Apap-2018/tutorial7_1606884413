package com.apap.tutorial7.controller; 

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.service.FlightService; 

@RestController 
@RequestMapping("/flight") 
public class FlightController { 
	@Autowired 
	private FlightService flightService; 

	@PostMapping(value= "/add") 
	public FlightModel addFlight(@RequestBody FlightModel flight) { 
		flightService.addFlight(flight);
		return (flight); 
	} 

	@PutMapping(value= "/update/{flightId}") 
	private String updateFlight(@PathVariable(value="flightId") long flightId,@RequestParam("destination") String destination, @RequestParam("origin") String origin, @RequestParam("time") Date time) { 
		FlightModel flight = flightService.getFlightDetailById(flightId); 
		if (flight.equals(null)) { 
			return "Couldn't find your flight"; 
		} 
		flight.setDestination(destination);
		flight.setOrigin(origin);
		flight.setTime(time);

		return "flight update success"; 
	} 

	@DeleteMapping(value= "/delete/{flightId}") 
	public String deleteFlight(@PathVariable(value="flightId") long flightId) { 
		FlightModel  flight = flightService.getFlightDetailById(flightId);
		flightService.deleteFlight(flight);
		return "flight has been deleted"; 
	} 

	@GetMapping(value= "/view/{flightNumber}") 
	public @ResponseBody FlightModel viewFlight(@PathVariable("flightNumber") String flightNumber) { 
		FlightModel flight = flightService.getFlightDetailByFlightNumber(flightNumber);
		return flight;
	}
	
	@GetMapping(value= "/all") 
	public @ResponseBody List<FlightModel> viewAllFlight() { 
		List<FlightModel> flight = flightService.getAll();
		return flight;
	}
}