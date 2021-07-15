package com.maven.demo.repository;

import com.maven.demo.model.Airport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface airportRepository extends JpaRepository <Airport, Long>{
    
}
