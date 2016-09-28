package com.cooksys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.Itinerary;
import com.cooksys.entity.SavedFlight;
import com.cooksys.entity.User;
import com.cooksys.repository.ItineraryRepository;
import com.cooksys.repository.SavedFlightRepository;
import com.cooksys.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repo;
	
	@Autowired
	SavedFlightRepository sfRepo;
	
	@Autowired
	ItineraryRepository itRepo;
	
		
	public List<User> getAll()
	{

		return repo.findAll();
		
	}
	
	public User read(Integer id)
	{
		return repo.findOne(id);
	}



	public List<Itinerary> indexItinerary(Integer id) {
		return itRepo.findByUserId(id);
	}

	public User createUser(User user) {
		return repo.save(user);
	}

	public List<SavedFlight> findFlight(SavedFlight flightsearch) {
		List<SavedFlight> savedList = sfRepo.findAll();
		for(SavedFlight flight: savedList){
			if(flight.getDestination() != flightsearch.getDestination()){
				savedList.remove(flight);
				}
			else if (flight.getOrigin() != flightsearch.getOrigin())
			{
					savedList.remove(flight);
				}
			}
		return savedList;
		}
		

	public List<SavedFlight> getAllFlights() {
		return sfRepo.findAll();
	}

	


	public Itinerary createFlight(Integer id, List<Integer> flightId) 
		{
			
			List <SavedFlight> flights = new ArrayList<>();
			for(Integer i: flightId){
				flights.add(sfRepo.findById(i));
			}
			
			Itinerary itin = new Itinerary();
				itin.setFlights(flights);
				repo.findById(id).getItinerary().add(itin);
				return itin;
			
		}



	



}
