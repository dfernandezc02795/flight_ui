package com.maven.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "pay")
public class Pay {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idPay;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate datePay;

    @Column(nullable = false)
    private int valuePay;

    @Column(length = 40, nullable = false)
    private String typeVoucher;

    @Column(length = 40, nullable = false)
    private String numberVoucher;

    @ManyToOne
    @JoinColumn(name = "passengerId")
    private Passenger passengerId;

    @ManyToOne
    @JoinColumn(name = "reserveId")
    private Reserve reserveId;

    public Pay() {
    }

    public Pay(Passenger passengerId) {
        this.passengerId = passengerId;
    }

    public Pay(Reserve reserveId) {
        this.reserveId = reserveId;
    }

    public Pay(LocalDate datePay, int valuePay, String typeVoucher, String numberVoucher, Passenger passengerId) {
        this.datePay = datePay;
        this.valuePay = valuePay;
        this.typeVoucher = typeVoucher;
        this.numberVoucher = numberVoucher;
        this.passengerId = passengerId;
    }

    public Long getIdPay() {
        return idPay;
    }

    public void setIdPay(Long idPay) {
        this.idPay = idPay;
    }

    public LocalDate getDatePay() {
        return datePay;
    }

    public void setDatePay(LocalDate datePay) {
        this.datePay = datePay;
    }

    public int getValuePay() {
        return valuePay;
    }

    public void setValuePay(int valuePay) {
        this.valuePay = valuePay;
    }

    public String getTypeVoucher() {
        return typeVoucher;
    }

    public void setTypeVoucher(String typeVoucher) {
        this.typeVoucher = typeVoucher;
    }

    public String getNumberVoucher() {
        return numberVoucher;
    }

    public void setNumberVoucher(String numberVoucher) {
        this.numberVoucher = numberVoucher;
    }

    public Passenger getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Passenger passengerId) {
        this.passengerId = passengerId;
    }

    public Reserve getReserveId() {
        return reserveId;
    }

    public void setReserveId(Reserve reserveId) {
        this.reserveId = reserveId;
    }

    
}
