package com.maven.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.maven.demo.model.Plane;
import com.maven.demo.services.planeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/plane")
public class planeController {

    @Autowired
    planeService planeService;

    @GetMapping()
    public ArrayList<Plane> getPlanes() {
        return planeService.getPlanes();
    }

    @PostMapping()
    public Plane savePlane(@RequestBody Plane plane) {
        return this.planeService.savePlane(plane);
    }
    
    @GetMapping(value = "/{id}")
    public Optional<Plane> getPlaneId(@PathVariable("id") Long id) {
        return this.planeService.getIdPlane(id);
    }

    @DeleteMapping(path = "/{id]")
    public String deletePlane(@PathVariable("id") Long id) {
        boolean ok = this.planeService.deletePlane(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }
}
