package com.maven.demo.services;

import java.util.*;

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

    public List<Passenger> getByDocumentPassenger(String numberDocument) {
        return passengerRepository.findBynumberDocument(numberDocument);
    }

    public Passenger updatePassenger(Passenger passenger, Long id) {
        
        Optional<Passenger> optional = passengerRepository.findById(passenger.getIdPassenger());

        Passenger exisPassenger = optional.get();
        exisPassenger.setName(passenger.getName());
        exisPassenger.setLastName(passenger.getLastName());
        exisPassenger.setBirthDate(passenger.getBirthDate());
        exisPassenger.setTelephone(passenger.getTelephone());
        exisPassenger.setEmail(passenger.getEmail());
        exisPassenger.setCountryId(passenger.getCountryId());

        return passengerRepository.save(exisPassenger);
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