package com.maven.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.maven.demo.model.Flight;
import com.maven.demo.repository.flightRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class fligthService {

    @Autowired
    flightRepository flightRepository;

    public ArrayList<Flight> getFlights() {
        return (ArrayList<Flight>) flightRepository.findAll();
    }

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }
    
    public Optional<Flight> getIdFlight(Long id) {
        return flightRepository.findById(id);
    }

    public boolean deleteFlight(Long id) {
        try {
            flightRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
