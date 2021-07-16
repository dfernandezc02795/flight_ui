package com.maven.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.maven.demo.model.Airline;
import com.maven.demo.repository.airlineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class airlineService {
    
    @Autowired
    airlineRepository airlineRepository;

    public ArrayList<Airline> getAirlines() {
        return (ArrayList<Airline>) airlineRepository.findAll();
    }

    public Airline saveAirline(Airline airline) {
        return airlineRepository.save(airline);
    }

    public Optional<Airline> getIdAirline(Long id) {
        return airlineRepository.findById(id);
    }
    
    public boolean deleteAirline(Long id){
        try {
            airlineRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
