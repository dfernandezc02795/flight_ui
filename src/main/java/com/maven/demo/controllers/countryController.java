package com.maven.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.maven.demo.model.Country;
import com.maven.demo.services.countryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return this.countryService.saveCountry(country);
    }

    @GetMapping(value = "/{id}")
    public Optional<Country> getCountrId(@PathVariable("id") Long id) {
        return this.countryService.getIdCountrys(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteCountryId(@PathVariable("id") Long id) {
        boolean ok = this.countryService.deleteCountry(id);
        if (ok) {
            return "Se eliminó el usuario con id" + id;
        } else {
            return "No pudo eliminar el usurio con id" + id;
        }
    }
}
