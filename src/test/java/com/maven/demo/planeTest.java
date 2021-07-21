package com.maven.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.maven.demo.model.Airline;
import com.maven.demo.model.Plane;
import com.maven.demo.repository.airlineRepository;
import com.maven.demo.repository.planeRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class planeTest {

    @Autowired
    private planeRepository repoPlane;

    @Autowired 
    private airlineRepository repoAirline;

    @Test
    public void savePlane() {
        Airline airline = new Airline("009007", "Avianca");
        airline = repoAirline.save(airline);

        Plane plane = new Plane("123k", 16, airline);
        repoPlane.save(plane);

        repoPlane.flush();

        assertEquals(1, repoPlane.findAll().size());
    }
    
    @Test
    public void getPlanes() {
        Airline airline = new Airline("009007", "Avianca");
        airline = repoAirline.save(airline);

        Plane plane = new Plane("123k", 16, airline);
        Plane plane1 = new Plane("124k", 22, airline);
        Plane plane2 = new Plane("125k", 8, airline);

        repoPlane.save(plane);
        repoPlane.save(plane1);
        repoPlane.save(plane2);

        repoPlane.flush();

        assertEquals(3, repoPlane.findAll().size());
    }

    
}
