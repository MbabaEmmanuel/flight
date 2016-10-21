package com.cooksys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.entity.Location;
import com.cooksys.entity.SavedFlight;

@Repository
public interface SavedFlightRepository extends JpaRepository<SavedFlight, Integer>{


	SavedFlight findById(Integer id);
	

}
