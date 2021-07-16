package com.maven.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idSeat;

    @Column(nullable = false)
    private int rowSeat;

    @Column(length = 15, nullable = false)
    private String letterSeat;

    @Column(length = 20, nullable = false)
    private String locationSeat;

    @Column(length = 20, nullable = false)
    private String typeSeat;

    @OneToMany(mappedBy = "seatId")
    List<Flight> flights;

    public Seat() {
    }

    public Seat(Long idSeat) {
        this.idSeat = idSeat;
    }

    public Long getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(Long idSeat) {
        this.idSeat = idSeat;
    }

    public int getRowSeat() {
        return rowSeat;
    }

    public void setRowSeat(int rowSeat) {
        this.rowSeat = rowSeat;
    }

    public String getLetterSeat() {
        return letterSeat;
    }

    public void setLetterSeat(String letterSeat) {
        this.letterSeat = letterSeat;
    }

    public String getLocationSeat() {
        return locationSeat;
    }

    public void setLocationSeat(String locationSeat) {
        this.locationSeat = locationSeat;
    }

    public String getTypeSeat() {
        return typeSeat;
    }

    public void setTypeSeat(String typeSeat) {
        this.typeSeat = typeSeat;
    }
}
