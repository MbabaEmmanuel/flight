package com.cooksys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.Itinerary;



public interface ItineraryRepository extends JpaRepository<Itinerary, Integer> {
	
	Itinerary findById(Integer id);
	List<Itinerary> findByUserId(Integer id);

}
