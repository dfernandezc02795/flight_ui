package com.maven.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.maven.demo.model.Origin;
import com.maven.demo.services.originService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/origin")
public class originController {

    @Autowired
    originService originService;
    
    @GetMapping
    public ArrayList<Origin> getOrigins() {
        return originService.getOrigins();
    }

    @PostMapping
    public Origin saveDestination(@RequestBody Origin origin) {
        return this.originService.saveOrigin(origin);
    }

    @GetMapping(value = "/{id}")
    public Optional<Origin> getOriginId(@PathVariable("id") Long id) {
        return this.originService.getIdOrigin(id);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteOrigin(@PathVariable("id") Long id) {
        boolean ok = this.originService.deleleteOrigin(id);
        if (ok) {
            return "Se eliminó el usuario con id" + id;
        } else {
            return "No pudo eliminar el usurio con id" + id;
        }
    }
    
}
