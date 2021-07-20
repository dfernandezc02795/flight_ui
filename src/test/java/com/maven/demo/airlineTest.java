package com.maven.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.maven.demo.model.Airline;
import com.maven.demo.repository.airlineRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class airlineTest {

    @Autowired
    private airlineRepository repoAirline;

    @Test
    public void saveAirline() {

        Airline airline = new Airline("009008178", "Avianca");

        airline = repoAirline.save(airline);

        repoAirline.flush();

        assertEquals(1, repoAirline.findAll().size());
    }

    @Test
    public void getAirlines() {

        Airline airline = new Airline("009008178", "Avianca");
        Airline airline1 = new Airline("009008178", "EasyFly");
        Airline airline2 = new Airline("009008178", "Latam");

        repoAirline.save(airline);
        repoAirline.save(airline1);
        repoAirline.save(airline2);

        repoAirline.flush();

        assertEquals(3, repoAirline.findAll().size());
        
    }
    
}
