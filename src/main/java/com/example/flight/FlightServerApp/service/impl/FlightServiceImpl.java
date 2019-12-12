package com.example.flight.FlightServerApp.service.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.flight.FlightServerApp.model.FlightDetails;
import com.example.flight.FlightServerApp.service.FlightService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author hemanth
 * This implementation class is used to get flight related services
 *
 */
@Service
public class FlightServiceImpl implements FlightService {

	/* this method to get the all flight search details
	 * no args
	 * return list of all flight details
	 */
	@Override
	public List<FlightDetails> getFlightDetails() {
		ObjectMapper mapper = new ObjectMapper();
		List<FlightDetails> details =null;
		TypeReference<List<FlightDetails>> typeReference = new TypeReference<List<FlightDetails>>(){};
		InputStream inputStream = null;
		
		File file = null;
	    try {
	        file = ResourceUtils.getFile("classpath:flight-sample.json");
	        //Read File Content
	        inputStream = new ByteArrayInputStream( Files.readAllBytes(file.toPath()));;
			details = mapper.readValue(inputStream,typeReference);
		} catch (IOException e){}
		
		return details;
	}

}
