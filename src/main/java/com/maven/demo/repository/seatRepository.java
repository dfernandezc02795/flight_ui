package com.maven.demo.repository;

import com.maven.demo.model.Seat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface seatRepository extends JpaRepository<Seat, Long> {
    
}
