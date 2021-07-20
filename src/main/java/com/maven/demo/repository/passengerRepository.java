package com.maven.demo.repository;

import java.util.List;

import com.maven.demo.model.Passenger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface passengerRepository extends JpaRepository<Passenger, Long> {

    List<Passenger> findBynumberDocument(String document);
}
