package com.maven.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.maven.demo.model.Country;
import com.maven.demo.services.countryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class countryController {

    @Autowired
    countryService countryService;

    @GetMapping
    public ArrayList<Country> getCountries() {
        return countryService.getCountries();
    }

    @PostMapping
    public Country saveCountry(@RequestBody Country country) {
        return  this.countryService.saveCountry(country)
    }
}
