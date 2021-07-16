package com.maven.demo.repository;

import com.maven.demo.model.Rate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface rateRepository extends JpaRepository<Rate, Long>{
    
}
