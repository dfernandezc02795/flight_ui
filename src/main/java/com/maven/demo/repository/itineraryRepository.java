package com.maven.demo.repository;

import com.maven.demo.model.Itinerario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface itineraryRepository extends JpaRepository<Itinerario, Long>{
    
}
