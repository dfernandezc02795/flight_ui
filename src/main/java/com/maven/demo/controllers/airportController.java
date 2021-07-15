package com.maven.demo.controllers;

import java.util.*;

import com.maven.demo.model.Airport;
import com.maven.demo.services.airportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/airport")
public class airportController {

    @Autowired
    airportService airportService;

    @GetMapping()
    public ArrayList<Airport> getAirports() {
        return airportService.getAirports();
    }
    
    @PostMapping()
    public Airport saveAirport(@RequestBody Airport airport) {
        return this.airportService.saveAirport(airport);
    }

    @GetMapping(value="/{id}")
    public Optional<Airport> getAirportId(@PathVariable("id") Long id) {
        return this.airportService.getIdAirport(id);
    }
    
    @DeleteMapping(path = "/{id}")
    public String deleteAirportId(@PathVariable("id") Long id) {
        boolean ok = this.airportService.deleteAirport(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        } else {
            return "No pudo eliminar el usuario con id " + id;
        }
    }
    
    
    
}
