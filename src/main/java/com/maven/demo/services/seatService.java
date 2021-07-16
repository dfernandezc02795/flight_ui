package com.maven.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.maven.demo.model.Seat;
import com.maven.demo.repository.seatRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class seatService {

    @Autowired
    seatRepository seatRepository;

    public ArrayList<Seat> getSeats() {
        return (ArrayList<Seat>) seatRepository.findAll();
    }
    
    public Seat saveSeat(Seat seat) {
        return seatRepository.save(seat);
    }
    
    public Optional<Seat> getIdSeat(Long id) {
        return seatRepository.findById(id);
    }

    public boolean deleteSeat(Long id) {
        try {
            seatRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
