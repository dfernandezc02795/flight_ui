package com.maven.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.maven.demo.model.Passenger;
import com.maven.demo.services.passengerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/passenger")
public class passengerController {
    @Autowired
    passengerService passengerService;

    @GetMapping()
    public ArrayList<Passenger> getPassengers() {
        return passengerService.getPassengers();
    }

    @PostMapping()
    public Passenger savePassenger(@RequestBody Passenger passenger) {
        return this.passengerService.savePassenger(passenger);
    }

    @GetMapping(value = "/{id}")
    public Optional<Passenger> getPassengerId(@PathVariable("id") Long id){
        return this.passengerService.getIdPassengers(id);
    }
    
    @DeleteMapping(path = "/{id}")
    public String deletePassangerId(@PathVariable("id") Long id) {
        boolean ok = this.passengerService.deletePassanger(id);
        if (ok) {
            return "Se eliminó el usuario con id" + id;
        } else {
            return "No pudo eliminar el usuario con id" + id;
        }
    }
    

    
}
