package com.cooksys.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cooksys.entity.Itinerary;
import com.cooksys.entity.SavedFlight;

public class ItineraryResponse {
	
	private Integer id;
	private List<SavedFlight> savedFlight;
	
	
	public ItineraryResponse(Integer id, List<SavedFlight> savedFlight) {
		super();
		this.id = id;
		this.savedFlight = savedFlight;
	}
	
	public ItineraryResponse(Itinerary itinerary) {
		super();
		this.id = itinerary.getId();
		this.savedFlight = itinerary.getFlights();
	}

	public static List<ItineraryResponse> list(List<Itinerary> list)
	{
		ArrayList<ItineraryResponse> result = new ArrayList<>();
		for (Itinerary itinerary: list){
			result.add(new ItineraryResponse(itinerary));
		}
		return result;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<SavedFlight> getSavedFlight() {
		return savedFlight;
	}

	public void setSavedFlight(List<SavedFlight> savedFlight) {
		this.savedFlight = savedFlight;
	}
	
	
	

}
