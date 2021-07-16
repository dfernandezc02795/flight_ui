package com.maven.demo.model;

import java.sql.Date;
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
    private Date dateReserve;

    @Column(nullable = false)
    private int totalPay;

    @ManyToOne
    @JoinColumn(name = "itineraryId")
    private Itinerario itineraryId;

    @OneToMany(mappedBy = "reserveId")
    List<Pay> payments;

    public Reserve() {
    }    

    public Reserve(Itinerario itineraryId) {
        this.itineraryId = itineraryId;
    }
    
    public Reserve(Long idReserve) {
        this.idReserve = idReserve;
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

    public Date getDateReserve() {
        return dateReserve;
    }

    public void setDateReserve(Date dateReserve) {
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
