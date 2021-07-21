package com.maven.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;
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
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "itinerary")
public class Itinerario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idItinerary;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateItinerary;
    
    @Column(nullable = false)
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime timeItinerary;

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

    public Itinerario(LocalDate dateItinerary, LocalTime timeItinerary, Origin originId, Destination destinationId) {
        this.dateItinerary = dateItinerary;
        this.timeItinerary = timeItinerary;
        this.originId = originId;
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
    

    public LocalDate getDateItinerary() {
        return dateItinerary;
    }

    public void setDateItinerary(LocalDate dateItinerary) {
        this.dateItinerary = dateItinerary;
    }
    
    public Origin getOriginId() {
        return originId;
    }

    public LocalTime getTimeItinerary() {
        return timeItinerary;
    }

    public void setTimeItinerary(LocalTime timeItinerary) {
        this.timeItinerary = timeItinerary;
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
