package com.cooksys.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SavedFlight {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	//Name of city where flight originates
	private String origin;
	
	@Column
	//Name of city where flight lands
	private String destination;
	
	@Column
	//How many hours flight is in the air
	private long flightTime;
	
	@Column(name = "off")
	//How many hours after the start of the day until the flight takes off
	private long offset;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Itinerary itinerary;
	
	
	
	public SavedFlight() {
		super();
	}


	
	
	public SavedFlight(Integer id, String origin, String destination, long flightTime, long offset) {
		super();
		this.id = id;
		this.origin = origin;
		this.destination = destination;
		this.flightTime = flightTime;
		this.offset = offset;
	}





	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public long getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(long flightTime) {
		this.flightTime = flightTime;
	}
	public long getOffset() {
		return offset;
	}
	public void setOffset(long offset) {
		this.offset = offset;
	}

	public Itinerary getItinerary() {
		return itinerary;
	}
	
	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}

	
	




}
