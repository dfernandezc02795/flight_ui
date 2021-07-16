package com.maven.demo.repository;

import com.maven.demo.model.Pay;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface payRepository extends JpaRepository<Pay, Long>{
    
}
