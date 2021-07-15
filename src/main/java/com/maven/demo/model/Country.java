package com.maven.demo.model;

import java.io.Serializable;
import java.util.List;
//import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
@Table(name = "country")
public class Country implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(unique = true, nullable = false)
    private Long idCountry;

    @Column(length = 30, nullable = false)
    private String name;

    @OneToMany(mappedBy = "countryId")
    List<Passenger> passengers;

    @JsonCreator
    public Country() {
    }  

    public Country(Long idCountry) {
        this.idCountry = idCountry;
    }



    public Long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Long idCountry) {
        this.idCountry = idCountry;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
