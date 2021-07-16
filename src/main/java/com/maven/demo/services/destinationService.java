package com.maven.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.maven.demo.model.Destination;
import com.maven.demo.repository.destinationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class destinationService {

    @Autowired
    destinationRepository destinationRepository;

    public ArrayList<Destination> getDestinations() {
        return (ArrayList<Destination>) destinationRepository.findAll();
    }

    public Destination saveDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    public Optional<Destination> getIdDestination(Long id) {
        return destinationRepository.findById(id);
    }
    
    public boolean deleteDestination(Long id) {
        try {
            destinationRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
