package com.maven.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.maven.demo.model.Pay;
import com.maven.demo.services.payService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
public class payController {

    @Autowired
    payService payService;

    @GetMapping
    public ArrayList<Pay> getPayments() {
        return payService.getPayments();
    }

    @PostMapping
    public Pay savePayment(@RequestBody Pay pay) {
        return this.payService.savePayment(pay);
    }

    @GetMapping(value = "/{id}")
    public Optional<Pay> getPaymentId(@PathVariable("id") Long id) {
        return this.payService.getIdPayment(id);
    }
    
    @DeleteMapping(value = "/{id}")
    public String deletePayment(@PathVariable("id") Long id) {
        boolean ok = this.payService.deletePayment(id);
        if (ok) {
            return "Se eliminó el usuario con id" + id;
        } else {
            return "No pudo eliminar el usurio con id" + id;
        }
    }
}
