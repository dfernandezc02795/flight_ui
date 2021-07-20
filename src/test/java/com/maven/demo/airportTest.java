package com.maven.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.maven.demo.model.Airport;
import com.maven.demo.model.Country;
import com.maven.demo.repository.airportRepository;
import com.maven.demo.repository.countryRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class airportTest {

    @Autowired
    private countryRepository repoCountry;

    @Autowired
    private airportRepository repoAirport;

    @Test
    public void saveAirport() {

        Country country = new Country("Brasil");
        country = repoCountry.save(country);

        Airport airport = new Airport("Mantecaña", country);
        airport = repoAirport.save(airport);

        assertEquals(1, repoAirport.findAll().size());

    }

    @Test
    public void getAirports() {
        
        Country country = new Country("Brasil");
        country = repoCountry.save(country);

        Airport airport = new Airport("Mantecaña", country);
        Airport airport1 = new Airport("Eden", country);
        Airport airport2 = new Airport("Santa Ana", country);

        airport = repoAirport.save(airport);
        airport = repoAirport.save(airport1);
        airport = repoAirport.save(airport2);

        repoAirport.flush();

        assertEquals(3, repoAirport.findAll().size());
    }
    
}
