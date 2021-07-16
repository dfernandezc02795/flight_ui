package com.maven.demo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "airport")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(unique = true, nullable = false)
    private Long idAirport;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "countryId")
    private Country countryId;

    public Airport() {
    }

    public Airport(Country countryId) {
        this.countryId = countryId;
    }

    public Long getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(Long idAirport) {
        this.idAirport = idAirport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }
}
