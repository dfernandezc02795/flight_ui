package com.maven.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.maven.demo.model.Pay;
import com.maven.demo.repository.payRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class payService {

    @Autowired
    payRepository payRepository;

    public ArrayList<Pay> getPayments() {
        return (ArrayList<Pay>) payRepository.findAll();
    }

    public Pay savePayment(Pay pay) {
        return payRepository.save(pay);
    }
    
    public Optional<Pay> getIdPayment(Long id) {
        return payRepository.findById(id);
    }

    public boolean deletePayment(Long id) {
        try {
            payRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
