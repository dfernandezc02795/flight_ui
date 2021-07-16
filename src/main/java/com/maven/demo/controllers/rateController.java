package com.maven.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.maven.demo.model.Rate;
import com.maven.demo.services.rateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rate")
public class rateController {

    @Autowired
    rateService rateService;

    @GetMapping()
    public ArrayList<Rate> getRates() {
        return rateService.getRates();
    }

    @PostMapping()
    public Rate saveRate(@RequestBody Rate rate) {
        return this.rateService.saveRate(rate);
    }

    @GetMapping(value = "/{id}")
    public Optional<Rate> getRateId(@PathVariable("id") Long id) {
        return this.rateService.getIdRate(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteRate(@PathVariable("id") Long id) {
        boolean ok = this.rateService.deleteRate(id);
        if (ok) {
            return "Se eliminó el usuario con id" + id;
        } else {
            return "No pudo eliminar el usuario con id" + id;
        }
    }
    
}
