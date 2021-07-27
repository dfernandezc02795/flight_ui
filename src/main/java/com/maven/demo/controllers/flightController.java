package com.maven.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.maven.demo.model.Flight;
import com.maven.demo.services.fligthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight")
public class flightController {

    @Autowired
    fligthService flightService;

    @GetMapping
    public ArrayList<Flight> getFlights() {
        return flightService.getFlights();
    }

    @PostMapping
    public Flight saveFlight(@RequestBody Flight flight) {
        return this.flightService.saveFlight(flight);
    }
    
    @GetMapping(value = "/{id}")
    public Optional<Flight> getFlightId(@PathVariable("id") Long id) {
        return this.flightService.getIdFlight(id);
    }
    @DeleteMapping(path = "/{id}")
    public String deleteFlightId(@PathVariable("id") Long id) {
        boolean ok = this.flightService.deleteFlight(id);
        if (ok) {
            return "Se eliminó el usuario con id" + id;
        } else {
            return "No pudo eliminar el usurio con id" + id;
        }
    }

    @GetMapping("/query")
    public List<Flight> getByDocumentPassenger(@RequestParam("flightNumber") String flightNumber) {
        return this.flightService.getByNumberFlights(flightNumber);
    }
}
