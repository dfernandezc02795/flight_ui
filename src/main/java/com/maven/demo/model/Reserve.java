package com.maven.demo.model;

import java.time.LocalDate;
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

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "reserve")
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idReserve;

    @Column(unique = true, nullable = false, length = 20)
    private String codeReserve;

    @Column(nullable = false)    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateReserve;

    @Column(nullable = false)
    private int totalPay;

    @ManyToOne
    @JoinColumn(name = "itineraryId")
    private Itinerario itineraryId;

    @OneToMany(mappedBy = "reserveId")
    List<Pay> payments;

    @OneToMany(mappedBy = "reserveId")
    List<Flight> flights;

    public Reserve() {
    }    

    public Reserve(Itinerario itineraryId) {
        this.itineraryId = itineraryId;
    }
    
    public Reserve(Long idReserve) {
        this.idReserve = idReserve;
    }

    public Reserve(String codeReserve, LocalDate dateReserve, int totalPay, Itinerario itineraryId) {
        this.codeReserve = codeReserve;
        this.dateReserve = dateReserve;
        this.totalPay = totalPay;
        this.itineraryId = itineraryId;
    }

    public Long getIdReserve() {
        return idReserve;
    }

    public void setIdReserve(Long idReserve) {
        this.idReserve = idReserve;
    }

    public String getCodeReserve() {
        return codeReserve;
    }

    public void setCodeReserve(String codeReserve) {
        this.codeReserve = codeReserve;
    }
    
    public LocalDate getDateReserve() {
        return dateReserve;
    }

    public void setDateReserve(LocalDate dateReserve) {
        this.dateReserve = dateReserve;
    }

    public int getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(int totalPay) {
        this.totalPay = totalPay;
    }

    public Itinerario getItineraryId() {
        return itineraryId;
    }

    public void setItineraryId(Itinerario itineraryId) {
        this.itineraryId = itineraryId;
    }
}
