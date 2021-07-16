package com.maven.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.maven.demo.model.Airline;
import com.maven.demo.services.airlineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airline")
public class airlineController {

    @Autowired
    airlineService airlineService;

    @GetMapping()
    public ArrayList<Airline> getAirlines() {
        return airlineService.getAirlines();
    }

    @PostMapping()
    public Airline saveAirline(@RequestBody Airline airline) {
        return this.airlineService.saveAirline(airline);
    }

    @GetMapping(value = "/{id}")
    public Optional<Airline> getAirlineId(@PathVariable("id") Long id) {
        return this.airlineService.getIdAirline(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteAirline(@PathVariable("id") Long id) {
        boolean ok = this.airlineService.deleteAirline(id);
        if (ok) {
            return "Se eliminó el usuario con id" + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }
    
}
