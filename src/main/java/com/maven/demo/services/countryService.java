package com.maven.demo.services;

import java.util.*;

import com.maven.demo.model.Country;
import com.maven.demo.repository.countryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class countryService {

    @Autowired
    countryRepository countryRepository;

    public ArrayList<Country> getCountries() {
        return (ArrayList<Country>) countryRepository.findAll();
    }

    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    public Optional<Country> getIdCountrys(Long id) {
        return countryRepository.findById(id);
    }

    public boolean deleteCountry(Long id) {
        try {
            countryRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }




    
}
