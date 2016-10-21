package com.cooksys.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.cooksys.entity.Itinerary;
import com.cooksys.entity.Location;
import com.cooksys.entity.SavedFlight;
import com.cooksys.entity.User;
import com.cooksys.repository.SavedFlightRepository;
import com.cooksys.service.UserService;



@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService service;
	

	@RequestMapping
	public List<User> get() {
		return service.getAll();
	}
	
	@RequestMapping(value = {"allFlights"}, method=RequestMethod.GET)
	public List<SavedFlight> getFlights() {
		return service.getAllFlights();
	}
	
	@RequestMapping(value = "{id}", method=RequestMethod.GET)
	public User getUser(@PathVariable Integer id) {
		return this.service.read(id);
	}
	
	@RequestMapping(value = {"itinerary/{id}"}, method=RequestMethod.GET)
	public List<Itinerary> getItinerary(@PathVariable Integer id) {
		return service.indexItinerary(id);
	}
	
	@RequestMapping(value = {"itinerary/{id}"}, method=RequestMethod.POST)
	public Itinerary createItinerary(@PathVariable Integer id, @RequestBody List<SavedFlight> flights) {
		return this.service.createFlight(id, flights);
	}
	
	
	
	
	@RequestMapping(method=RequestMethod.POST)
	public User postUser(@RequestBody User user) {
		return this.service.createUser(user);
	}
		
	
	

	
	
	
	
}
