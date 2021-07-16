package com.maven.demo.model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
@Table(name = "itinerary")
public class Itinerario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idItinerary;

    @Column(nullable = false)
    private Date dateItinerary;
    
    @Column(nullable = false)
    private Time timeItinerary;

    @ManyToOne
    @JoinColumn(name = "originId")
    private Origin originId;

    @ManyToOne
    @JoinColumn(name = "destinationId")
    private Destination destinationId;

    @OneToMany(mappedBy = "itineraryId")
    List<Reserve> reserves;

    @JsonCreator
    public Itinerario() {
    }

    public Itinerario(Origin originId) {
        this.originId = originId;
    }

    public Itinerario(Destination destinationId) {
        this.destinationId = destinationId;
    }

    

    public Itinerario(Long idItinerary) {
        this.idItinerary = idItinerary;
    }

    public Long getIdItinerary() {
        return idItinerary;
    }

    public void setIdItinerary(Long idItinerary) {
        this.idItinerary = idItinerary;
    }

    public Date getDateItinerary() {
        return dateItinerary;
    }

    public void setDateItinerary(Date dateItinerary) {
        this.dateItinerary = dateItinerary;
    }

    public Time getTimeItinerary() {
        return timeItinerary;
    }

    public void setTimeItinerary(Time timeItinerary) {
        this.timeItinerary = timeItinerary;
    }

    public Origin getOriginId() {
        return originId;
    }

    public void setOriginId(Origin originId) {
        this.originId = originId;
    }

    public Destination getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Destination destinationId) {
        this.destinationId = destinationId;
    }

    
}
