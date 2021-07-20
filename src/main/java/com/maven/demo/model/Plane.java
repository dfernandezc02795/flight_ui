package com.maven.demo.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "plane")
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idPlane;

    @Column(length = 30, nullable = false, unique = true)
    private String registrationNumber;
    
    @Column(nullable = false)
    private int capacity;

    @ManyToOne
    @JoinColumn(name =  "airlineId")
    private Airline airlineId;

    @OneToMany(mappedBy = "planeId")
    List<Flight> flights;

    public Plane() {
    }

    public Plane(Airline airlineId) {
        this.airlineId = airlineId;
    }

    public Plane(Long idPlane) {
        this.idPlane = idPlane;
    }

    public Plane(String registrationNumber, int capacity, Airline airlineId) {
        this.registrationNumber = registrationNumber;
        this.capacity = capacity;
        this.airlineId = airlineId;
    }

    public Long getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(Long idPlane) {
        this.idPlane = idPlane;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Airline getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Airline airlineId) {
        this.airlineId = airlineId;
    }
}
