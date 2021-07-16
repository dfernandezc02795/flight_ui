package com.maven.demo.repository;

import com.maven.demo.model.Reserve;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface reserveRepository extends JpaRepository<Reserve, Long>{
    
}
