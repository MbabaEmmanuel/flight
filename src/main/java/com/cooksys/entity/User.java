package com.cooksys.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "User")
public class User {
	
	@Id
	@SequenceGenerator(name="user_id_seq", sequenceName="user_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="user_id_seq")
	@Column(updatable=false)
	private Integer id;
	
	@Column(updatable=false)
	private String userName;
	
	@Column
	private String password;
	
	@OneToMany(mappedBy = "user" ,fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Itinerary> itinerary;
	
	

	public User(Integer id, String userName, String password, List<Itinerary> itinerary) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.itinerary = itinerary;
	}

	public User() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Itinerary> getItinerary() {
		return itinerary;
	}

	public void setItinerary(Itinerary itinerary) {
		this.itinerary.add(itinerary);
	}

	
	
	
}
