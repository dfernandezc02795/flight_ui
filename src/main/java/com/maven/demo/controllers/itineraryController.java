package com.maven.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.maven.demo.model.Itinerario;
import com.maven.demo.services.itineraryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itinerary")
public class itineraryController {

    @Autowired
    itineraryService itineraryService;

    @GetMapping
    public ArrayList<Itinerario> getItineries() {
        return itineraryService.getItineraries();
    }

    @PostMapping
    public Itinerario saveItinerary(@RequestBody Itinerario itinerary) {
        return this.itineraryService.saveItinerary(itinerary);
    }

    @GetMapping(value = "/{id}")
    public Optional<Itinerario> getIdItinerary(@PathVariable("id") long id) {
        return this.itineraryService.getIdItinerary(id);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteItinerary(@PathVariable("id") Long id) {
        boolean ok = this.itineraryService.deleteItinerary(id);
        if (ok) {
            return "Se eliminó el usuario con id" + id;
        } else {
            return "No pudo eliminar el usurio con id" + id;
        }
        
    }
    
    
}
