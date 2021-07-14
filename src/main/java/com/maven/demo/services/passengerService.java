package com.maven.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.maven.demo.model.Passenger;
import com.maven.demo.repository.passengerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class passengerService {
    @Autowired
    passengerRepository passengerRepository;

    public ArrayList<Passenger> getPassengers() {
        return (ArrayList<Passenger>) passengerRepository.findAll();
    }

    public Passenger savePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Optional<Passenger> getIdPassengers(Long id) {
        return passengerRepository.findById(id);
    }

    public boolean deletePassanger(Long id) {
        try {
            passengerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
