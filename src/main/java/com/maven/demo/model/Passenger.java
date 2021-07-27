package com.maven.demo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long idPassenger;

    @Column(length = 25, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String lastName; 

    @Column(length = 50, nullable = false)
    private String typeDocument;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Column(length = 25, nullable = false, unique = true)
    private String numberDocument;

    @Column(length = 18, nullable = true)
    private String telephone;

    @Column(length = 25, nullable = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "countryId")
    private Country countryId;

    @OneToMany(mappedBy = "passengerId", orphanRemoval = true)
    List<Pay> payments;

    @OneToMany(mappedBy = "passengerId")
    List<Flight> flights;

    
    public Passenger() {
    }

    public Passenger(Country countryId) {
        this.countryId = countryId;
    }

    public Passenger(long idPassenger) {
        this.idPassenger = idPassenger;
    }
    
    public Passenger(LocalDate birthDate, Country countryId, String email, String lastName, String name, String numberDocument,String telephone,String typeDocument) {
        this.name = name;
        this.lastName = lastName;
        this.typeDocument = typeDocument;
        this.birthDate = birthDate;
        this.numberDocument = numberDocument;
        this.telephone = telephone;
        this.email = email;
        this.countryId = countryId;
    }

    public long getIdPassenger() {
        return idPassenger;
    }

    public void setIdPassenger(long idPassenger) {
        this.idPassenger = idPassenger;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNumberDocument() {
        return numberDocument;
    }

    public void setNumberDocument(String numberDocument) {
        this.numberDocument = numberDocument;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

}


