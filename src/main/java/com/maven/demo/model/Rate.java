package com.maven.demo.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;


@Entity
@Table(name = "rate")
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idRate;

    @Column(nullable = false, unique = true)
    private String classPlane;    

    @Column(nullable = false)
    private int valuePay;

    @OneToMany(mappedBy = "rateId")
    List<Flight> flights;

    @JsonCreator
    public Rate() {
    }

    public Rate(Long idRate) {
        this.idRate = idRate;
    }

    public Rate(Long idRate, int valuePay) {
        this.idRate = idRate;
        this.valuePay = valuePay;
    }

    public Rate(String classPlane, int valuePay) {
        this.classPlane = classPlane;
        this.valuePay = valuePay;
    }

    public Long getIdRate() {
        return idRate;
    }

    public void setIdRate(Long idRate) {
        this.idRate = idRate;
    }

    public String getClassPlane() {
        return classPlane;
    }

    public void setClassPlane(String classPlane) {
        this.classPlane = classPlane;
    }

    public int getValuePay() {
        return valuePay;
    }

    public void setValuePay(int valuePay) {
        this.valuePay = valuePay;
    }

    


    

    
    



    
}
