package com.maven.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.maven.demo.model.Rate;
import com.maven.demo.repository.rateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class rateService {

    @Autowired
    rateRepository rateRepository;

    public ArrayList<Rate> getRates() {
        return (ArrayList<Rate>) rateRepository.findAll();
    }

    public Rate saveRate(Rate rate) {
        return rateRepository.save(rate);
    }

    public Optional<Rate> getIdRate(Long id) {
        return rateRepository.findById(id);
    }

    public boolean deleteRate(Long id) {
        try {
            rateRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
