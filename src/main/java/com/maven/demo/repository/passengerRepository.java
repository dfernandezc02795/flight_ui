package com.maven.demo.repository;

import com.maven.demo.model.Passenger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface passengerRepository extends CrudRepository<Passenger, Long> {
    
    
}
