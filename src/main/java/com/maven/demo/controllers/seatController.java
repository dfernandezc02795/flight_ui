package com.maven.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.maven.demo.model.Seat;
import com.maven.demo.services.seatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seat")
public class seatController {

    @Autowired
    seatService seatService;

    @GetMapping()
    public ArrayList<Seat> getSeats() {
        return seatService.getSeats();
    }
    
    @PostMapping()
    public Seat saveSeat(@RequestBody Seat seat) {
        return this.seatService.saveSeat(seat);
    }

    @GetMapping(value = "/{id}")
    public Optional<Seat> getSeatId(@PathVariable("id") Long id) {
        return this.seatService.getIdSeat(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteSeatId(@PathVariable("id") Long id) {
        boolean ok = this.seatService.deleteSeat(id);
        if (ok) {
            return "Se eliminó el usuario con id" + id;
        } else {
            return "No pudo eliminar el usurio con id" + id;
        }
    }
}
