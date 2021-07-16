package com.maven.demo.repository;

import com.maven.demo.model.Airline;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface airlineRepository extends JpaRepository<Airline, Long> {
    
}
