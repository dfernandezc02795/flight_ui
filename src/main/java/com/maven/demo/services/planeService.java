package com.maven.demo.services;

import java.util.*;

import com.maven.demo.model.Plane;
import com.maven.demo.repository.planeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class planeService {

    @Autowired
    planeRepository planeRepository;
    
    public ArrayList<Plane> getPlanes() {
        return (ArrayList<Plane>) planeRepository.findAll();
    }

    public Plane savePlane(Plane plane) {
        return planeRepository.save(plane);
    }
    
    public Optional<Plane> getIdPlane(Long id) {
        return planeRepository.findById(id);
    }

    public boolean deletePlane(Long id) {
        try {
            planeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
