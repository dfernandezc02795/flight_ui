package com.maven.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.maven.demo.model.Itinerario;
import com.maven.demo.repository.itineraryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class itineraryService {

    @Autowired
    itineraryRepository itineraryRepository;

    public ArrayList<Itinerario> getItineraries() {
        return (ArrayList<Itinerario>) itineraryRepository.findAll();
    }

    public Itinerario saveItinerary(Itinerario itinerary) {
        return itineraryRepository.save(itinerary);
    }

    public Optional<Itinerario> getIdItinerary(Long id) {
        return itineraryRepository.findById(id);
    }
    
    public boolean deleteItinerary(Long id) {
        try {
            itineraryRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
