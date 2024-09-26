package com.maven.demo.repository;

import java.util.List;

import com.maven.demo.model.Flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface flightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByFlightNumber(String flightNumber);  
    
}
