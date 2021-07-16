package com.maven.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.maven.demo.model.Destination;
import com.maven.demo.services.destinationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/destination")
public class destinationController {

    @Autowired
    destinationService destinationService;

    @GetMapping
    public ArrayList<Destination> getdestinations() {
        return destinationService.getDestinations();
    }

    @PostMapping
    public Destination saveDestination(@RequestBody Destination destination) {
        return this.destinationService.saveDestination(destination);
    }

    @GetMapping(value = "/{id}")
    public Optional<Destination> getDestinationId(@PathVariable("id") Long id) {
        return this.destinationService.getIdDestination(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteDestinationId(@PathVariable("id") Long id) {
        boolean ok = this.destinationService.deleteDestination(id);
        if (ok) {
            return "Se eliminó el usuario con id" + id;
        } else {
            return "No pudo eliminar el usurio con id" + id;
        }
    }
    
}
