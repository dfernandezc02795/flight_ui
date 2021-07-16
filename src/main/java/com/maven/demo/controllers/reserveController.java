package com.maven.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.maven.demo.model.Reserve;
import com.maven.demo.services.reserveService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reserve")
public class reserveController {

    @Autowired
    reserveService reserveService;

    @GetMapping
    public ArrayList<Reserve> getReserves() {
        return reserveService.getReserves();
    }

    @PostMapping
    public Reserve saveReserve(@RequestBody Reserve reserve) {
        return this.reserveService.saveReserve(reserve);
    }

    @GetMapping(value = "/{id}")
    public Optional<Reserve> getReserveId(@PathVariable("id") Long id) {
        return this.reserveService.getIdReserve(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteReserve(@PathVariable("id") Long id) {
        boolean ok = this.reserveService.deleteReserve(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        } else {
            return "No pudo eliminar el usuario con id" + id;
        }
    }    
}
