package com.maven.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.maven.demo.model.Origin;
import com.maven.demo.repository.originRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class originService {

    @Autowired
    originRepository originRepository;
    
    public ArrayList<Origin> getOrigins() {
        return (ArrayList<Origin>) originRepository.findAll();
    }

    public Origin saveOrigin(Origin origin) {
        return originRepository.save(origin);
    }

    public Optional<Origin> getIdOrigin(Long id) {
        return originRepository.findById(id);
    }

    public boolean deleleteOrigin(Long id) {
        try {
            originRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
