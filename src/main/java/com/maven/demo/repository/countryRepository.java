package com.maven.demo.repository;

import com.maven.demo.model.Country;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface countryRepository extends JpaRepository<Country, Long> {

}
