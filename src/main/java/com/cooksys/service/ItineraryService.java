package com.cooksys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.cooksys.entity.Itinerary;
import com.cooksys.repository.ItineraryRepository;

@Service
public class ItineraryService 
{
	@Autowired
	private final ItineraryRepository itineraryRepo;
	
	@Autowired
	public ItineraryService(ItineraryRepository itineraryRepo){
		super();
		this.itineraryRepo = itineraryRepo;
	}
	
	public Itinerary read(Integer id){
		return this.itineraryRepo.findOne(id);
	}
	
	
}
