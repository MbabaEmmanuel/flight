package com.cooksys.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	private final UserRepository repo;
	
	
	private final SavedFlightRepository sfRepo;
	
	
	private final ItineraryRepository itRepo;
	
	
	
	@Autowired	
	public UserService(UserRepository repo, SavedFlightRepository sfRepo, ItineraryRepository itRepo) {
		super();
		this.repo = repo;
		this.sfRepo = sfRepo;
		this.itRepo = itRepo;
	}

	public List<User> getAll()
	{

		return this.repo.findAll();
		
	}
	
	public User read(Integer id)
	{
		return this.repo.findOne(id);
	}





	public User createUser(User user) {
		return this.repo.save(user);
	}

	public List<SavedFlight> findFlight(SavedFlight flightsearch) {
		List<SavedFlight> savedList = this.sfRepo.findAll();
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
		return this.sfRepo.findAll();
	}

	
	public Itinerary saveItinerary(Itinerary itinerary){
		return this.itRepo.save(itinerary);
	}

	public Itinerary createFlight(Integer id, List<SavedFlight> flights) 
		{
			
		User userItinupdate = this.repo.findOne(id);
		Itinerary itinerary = new Itinerary();
		this.itRepo.saveAndFlush(itinerary);
		for(SavedFlight flight: flights){
			flight.setItinerary(itinerary);
			this.sfRepo.saveAndFlush(flight);
			}
		itinerary.setUser(userItinupdate);
		itinerary.setFlights(flights);
		
		userItinupdate.getItinerary().add(itinerary);
		
		this.repo.saveAndFlush(userItinupdate);
		return itinerary;
		
		
			
		}

	public List<Itinerary> indexItinerary(Integer id) {
		User useritin = this.read(id);
		return useritin.getItinerary();
		
	}

	



	



}
