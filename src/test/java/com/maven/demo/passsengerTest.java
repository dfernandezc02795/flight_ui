package com.maven.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import com.maven.demo.model.Country;
import com.maven.demo.model.Passenger;
import com.maven.demo.repository.countryRepository;
import com.maven.demo.repository.passengerRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class passsengerTest {

    @Autowired
    private passengerRepository repoPassenger;

    @Autowired
    private countryRepository repoCountry;

    LocalDate date = LocalDate.parse("2000-10-30");

    @Test
    public void savePassenger() {

        Country country = new Country("Colombia");
        repoCountry.save(country);
        country = repoCountry.save(country);

        Passenger passenger = new Passenger(date, country,"dfc@gmail.com", "Fernandez", "Daniela", "1234",  "4321","CC");

        passenger = repoPassenger.save(passenger);

        repoPassenger.flush();

        assertEquals(1, repoPassenger.findAll().size());
    }
    
    @Test
    public void getPassengers() {

        Country country = new Country("Colombia");
        repoCountry.save(country);
        country = repoCountry.save(country);

        Passenger passenger = new Passenger(date, country, "dfc@gmail.com", "Fernandez", "Daniela", "1234", "4321",
                "CC");

        Passenger passenger1 = new Passenger(date, country, "dfc@gmail.com", "Fernandez", "Daniela", "12346", "4321",
                "CC");

        Passenger passenger2 = new Passenger(date, country, "dfc@gmail.com", "Fernandez", "Daniela", "12345", "4321",
                "CC");

        repoPassenger.save(passenger);
        repoPassenger.save(passenger1);
        repoPassenger.save(passenger2);

        repoPassenger.flush();

        assertEquals(3, repoPassenger.findAll().size());
    }

    @Test
    public void deletePassenger() {

        Country country = new Country("Colombia");
        repoCountry.save(country);
        country = repoCountry.save(country);

        Passenger passenger = new Passenger(date, country, "dfc@gmail.com", "Fernandez", "Daniela", "1234", "4321",
                "CC");

        Passenger passenger1 = new Passenger(date, country, "dfc@gmail.com", "Fernandez", "Daniela", "12346", "4321",
                "CC");

        repoPassenger.save(passenger);
        repoPassenger.save(passenger1);

        repoPassenger.flush();

        repoPassenger.delete(passenger1);

        assertEquals(1, repoPassenger.findAll().size());
    }
    @Test
    public void getPassenger() {
        
        Country country = new Country("Colombia");
        repoCountry.save(country);
        country = repoCountry.save(country);

        Passenger passenger = new Passenger(date, country, "dfc@gmail.com", "Fernandez", "Daniela", "1234", "4321",
                "CC");
        
        repoPassenger.save(passenger);

        repoPassenger.flush();

        List<Passenger> getPassengerDocument = repoPassenger.findBynumberDocument("1234");
        for (Passenger p : getPassengerDocument) {
            assertEquals("1234", p.getNumberDocument());
            assertEquals("Daniela", p.getName());
        }
        
        assertEquals(1, repoPassenger.findAll().size());
    }
}
