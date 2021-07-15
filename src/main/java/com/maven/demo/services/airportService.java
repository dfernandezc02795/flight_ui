package com.maven.demo.services;

import java.util.*;

import com.maven.demo.model.Airport;
import com.maven.demo.repository.airportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class airportService {

    @Autowired
    airportRepository airportRepository;

    public ArrayList<Airport> getAirports() {
        return (ArrayList<Airport>) airportRepository.findAll();
    }

    public Airport saveAirport(Airport airport) {
        return airportRepository.save(airport);
    }
    
    public Optional<Airport> getIdAirport(Long id) {
        return airportRepository.findById(id);
    }

    public boolean deleteAirport(Long id) {
        try {
            airportRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
