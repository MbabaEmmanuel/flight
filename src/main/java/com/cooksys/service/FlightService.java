package com.cooksys.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cooksys.component.FlightGenerator;
import com.cooksys.controller.FlightNode;
import com.cooksys.entity.Itinerary;
import com.cooksys.entity.SavedFlight;
import com.cooksys.pojo.Flight;
import com.cooksys.repository.ItineraryRepository;
import com.cooksys.repository.SavedFlightRepository;
import com.cooksys.repository.UserRepository;

@Service
public class FlightService {

	@Autowired
	FlightGenerator generator;
	
	@Autowired
	SavedFlightRepository sfRepo;
	
	@Autowired
	ItineraryRepository itRepo;

	private ArrayList<Flight> flightList = new ArrayList<>();
	
	public ArrayList<Flight> getDailyFlightList()
	{
		return flightList;
	}
	
	//The fixedDelay parameter determines how often a new day is generated as expressed in milliseconds
	@Scheduled(fixedDelay=50000)
	private void refreshFlights()
	{
		
		flightList = generator.generateNewFlightList();
	
	
	}
	
}