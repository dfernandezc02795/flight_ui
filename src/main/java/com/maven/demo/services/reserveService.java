package com.maven.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.maven.demo.model.Reserve;
import com.maven.demo.repository.reserveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class reserveService {

    @Autowired
    reserveRepository reserveRepository;

    public ArrayList<Reserve> getReserves() {
        return (ArrayList<Reserve>) reserveRepository.findAll();
    }

    public Reserve saveReserve(Reserve reserve) {
        return reserveRepository.save(reserve);
    }

    public Optional<Reserve> getIdReserve(Long id) {
        return reserveRepository.findById(id);
    }

    public boolean deleteReserve(Long id) {
        try {
            reserveRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
