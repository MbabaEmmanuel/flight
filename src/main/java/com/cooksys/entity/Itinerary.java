package com.cooksys.entity;

import java.util.List;

import javax.persistence.*;


import com.cooksys.pojo.Flight;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Itinerary {
	@Id
	@SequenceGenerator(name="user_id_seq", sequenceName="user_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="user_id_seq")
	@Column (updatable=false)
	private Integer id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn
	private User user;
	
	@Column
	@ManyToMany(mappedBy= "itinerary", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<SavedFlight> flights;
	
	

	public Itinerary() {
		super();
	}


	public Itinerary(User userFlight, List<SavedFlight> flight) {
		super();
		this.user = userFlight;
		this.flights =  flight;
	}


	public Itinerary(List<SavedFlight> savedFlight) {
		this.flights = savedFlight;
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
	
	
	

}
