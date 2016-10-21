package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cooksys.entity.Itinerary;
import com.cooksys.service.ItineraryResponse;
import com.cooksys.service.ItineraryService;

@RestController
@CrossOrigin
@RequestMapping("itineraries")
public class ItineraryController {
	
	private final ItineraryService itineraryService;
	
	@Autowired
	public ItineraryController (ItineraryService itineraryService){
		super();
		this.itineraryService = itineraryService;
	}
	
	@RequestMapping(value = "{id}", method=RequestMethod.GET)
	public Itinerary read(@PathVariable Integer id) {
		return this.itineraryService.read(id);
	}

}
