package com.cooksys.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Itinerary  {
	
    @Id
    @SequenceGenerator(name = "itinerary_id_seq", sequenceName = "itinerary_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "itinerary_id_seq")
    @Column(updatable = false)
	private Integer id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JsonIgnore
	private User user;
	

	@OneToMany(mappedBy = "itinerary", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<SavedFlight> flights;
	


	public Itinerary() {
		super();
	}


	public Itinerary(User user, List<SavedFlight> flights) {
		super();
		this.user = user;
		this.flights = flights;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<SavedFlight> getFlights() {
		return flights;
	}

	public void setFlights(List<SavedFlight> flights) {
		this.flights = flights;
	}
	
	public void setFlight(SavedFlight flights) {
		this.flights.add(flights);
	}
	
	

}
