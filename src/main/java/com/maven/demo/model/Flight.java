package com.maven.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idFlight;

    @Column(unique = true, nullable = false)
    private String flightNumber;

    @Column(nullable = false)
    private String flightType;

    @Column(nullable = false)
    private String stateFlight;

    @ManyToOne
    @JoinColumn(name = "planeId")
    private Plane planeId;

    @ManyToOne
    @JoinColumn(name = "seatId")
    private Seat seatId;

    @ManyToOne
    @JoinColumn(name = "rateId")
    private Rate rateId;

    @ManyToOne
    @JoinColumn(name = "reserveId")
    private Reserve reserveId;

    @ManyToOne
    @JoinColumn(name = "airportId")
    private Airport airportId;

    public Flight() {
    }

    public Long getIdFlight() {
        return idFlight;
    }

    public Flight(Plane planeId, Seat seatId, Rate rateId, Reserve reserveId, Airport airportId) {
        this.planeId = planeId;
        this.seatId = seatId;
        this.rateId = rateId;
        this.reserveId = reserveId;
        this.airportId = airportId;
    }
    
    public Flight(String flightNumber, String flightType, String stateFlight, Plane planeId, Seat seatId, Rate rateId,
            Reserve reserveId, Airport airportId) {
        this.flightNumber = flightNumber;
        this.flightType = flightType;
        this.stateFlight = stateFlight;
        this.planeId = planeId;
        this.seatId = seatId;
        this.rateId = rateId;
        this.reserveId = reserveId;
        this.airportId = airportId;
    }

    public void setIdFlight(Long idFlight) {
        this.idFlight = idFlight;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public String getStateFlight() {
        return stateFlight;
    }

    public void setStateFlight(String stateFlight) {
        this.stateFlight = stateFlight;
    }

    public Plane getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Plane planeId) {
        this.planeId = planeId;
    }

    public Seat getSeatId() {
        return seatId;
    }

    public void setSeatId(Seat seatId) {
        this.seatId = seatId;
    }

    public Rate getRateId() {
        return rateId;
    }

    public void setRateId(Rate rateId) {
        this.rateId = rateId;
    }

    public Reserve getReserveId() {
        return reserveId;
    }

    public void setReserveId(Reserve reserveId) {
        this.reserveId = reserveId;
    }

    public Airport getAirportId() {
        return airportId;
    }

    public void setAirportId(Airport airportId) {
        this.airportId = airportId;
    }
}
