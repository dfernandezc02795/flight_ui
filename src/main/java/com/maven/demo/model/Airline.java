package com.maven.demo.model;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
@Table(name = "airline")
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable=false)
    private Long idAirline;

    @Column(unique = true, nullable = false)
    private String nit;

    @Column(length = 50, nullable = false)
    private String name;

    @OneToMany(mappedBy = "airlineId")
    List<Plane> planes;

    @JsonCreator
    public Airline() {
    }

    public Airline(Long idAirline) {
        this.idAirline = idAirline;
    }

    public Airline(String nit, String name) {
        this.nit = nit;
        this.name = name;
    }

    public Long getIdAirline() {
        return idAirline;
    }

    public void setIdAirline(Long idAirline) {
        this.idAirline = idAirline;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
