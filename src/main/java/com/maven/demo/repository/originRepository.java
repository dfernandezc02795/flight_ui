package com.maven.demo.repository;

import com.maven.demo.model.Origin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface originRepository extends JpaRepository<Origin, Long> {
    
}
