package com.maven.demo.repository;

import com.maven.demo.model.Plane;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface planeRepository extends JpaRepository<Plane, Long>{
    
}
