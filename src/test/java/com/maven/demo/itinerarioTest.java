package com.maven.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import com.maven.demo.model.Destination;
import com.maven.demo.model.Itinerario;
import com.maven.demo.model.Origin;
import com.maven.demo.repository.destinationRepository;
import com.maven.demo.repository.itineraryRepository;
import com.maven.demo.repository.originRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class itinerarioTest {

    @Autowired
    private itineraryRepository repoItinerary;
    
    @Autowired
    private originRepository repoOrigin;

    @Autowired
    private destinationRepository repoDestination;

    LocalDate date = LocalDate.parse("2000-10-30");

    LocalTime time = LocalTime.parse("12:00:00");

    @Test
    public void saveCountry() {

        Origin origin = new Origin("Armenia");
        origin = repoOrigin.save(origin);

        Destination destination = new Destination("Medellin");
        destination = repoDestination.save(destination);

        Itinerario itinerary = new Itinerario(date, time, origin, destination);

        repoItinerary.save(itinerary);

        repoItinerary.flush();

        assertEquals(1, repoItinerary.findAll().size());
    }

    @Test
    public void getIntineraries() {
        Origin origin = new Origin("Armenia");
        origin = repoOrigin.save(origin);

        Destination destination = new Destination("Medellin");
        destination = repoDestination.save(destination);

        Itinerario itinerary = new Itinerario(date, time, origin, destination);
        Itinerario itinerary1 = new Itinerario(date, time, origin, destination);
        Itinerario itinerary2 = new Itinerario(date, time, origin, destination);

        repoItinerary.save(itinerary);
        repoItinerary.save(itinerary1);
        repoItinerary.save(itinerary2);

        repoItinerary.flush();

        assertEquals(3, repoItinerary.findAll().size());
    }
    
}
