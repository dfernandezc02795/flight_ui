package com.maven.demo.repository;

import com.maven.demo.model.Destination;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface destinationRepository extends JpaRepository<Destination, Long>{
    
}
