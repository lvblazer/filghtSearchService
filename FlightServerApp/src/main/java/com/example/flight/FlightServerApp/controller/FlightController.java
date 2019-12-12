package com.example.flight.FlightServerApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flight.FlightServerApp.model.FlightDetails;
import com.example.flight.FlightServerApp.service.FlightService;

/**
 * @author hemanth
 * this class to define the all rest endpoints for light related search
 *
 */
@RestController
@RequestMapping("/flight")
public class FlightController {
	
	
	@Autowired
	private FlightService flightService;
	
	@GetMapping
	private ResponseEntity<List<FlightDetails>> getFlightDetails(){
		List<FlightDetails> details = flightService.getFlightDetails();
		
		return new ResponseEntity<List<FlightDetails>>(details, HttpStatus.OK);
	}
}
