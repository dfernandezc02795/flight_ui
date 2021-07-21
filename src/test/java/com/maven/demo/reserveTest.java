package com.maven.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import com.maven.demo.model.Destination;
import com.maven.demo.model.Itinerario;
import com.maven.demo.model.Origin;
import com.maven.demo.model.Reserve;
import com.maven.demo.repository.destinationRepository;
import com.maven.demo.repository.itineraryRepository;
import com.maven.demo.repository.originRepository;
import com.maven.demo.repository.reserveRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class reserveTest {

    @Autowired
    private reserveRepository repoReserve;

    @Autowired
    private itineraryRepository repoItinerary;

    @Autowired
    private originRepository repoOrigin;

    @Autowired
    private destinationRepository repoDestination;

    LocalDate date = LocalDate.parse("2000-10-30");

    LocalTime time = LocalTime.parse("12:00:00");

    @Test
    public void getReserves() {
        Origin origin = new Origin("Armenia");
        origin = repoOrigin.save(origin);

        Destination destination = new Destination("Medellin");
        destination = repoDestination.save(destination);

        Itinerario itinerary = new Itinerario(date, time, origin, destination);
        itinerary = repoItinerary.save(itinerary);

        Reserve reserve = new Reserve("8976", date, 120000, itinerary);

        repoReserve.save(reserve);

        repoReserve.flush();

        assertEquals(1, repoReserve.findAll().size());
    }

    @Test
    public void saveReserve() {
        Origin origin = new Origin("Armenia");
        origin = repoOrigin.save(origin);

        Destination destination = new Destination("Medellin");
        destination = repoDestination.save(destination);

        Itinerario itinerary = new Itinerario(date, time, origin, destination);
        itinerary = repoItinerary.save(itinerary);

        Reserve reserve = new Reserve("8977", date, 120000, itinerary);
        Reserve reserve1 = new Reserve("0976", date, 123400, itinerary);
        Reserve reserve2 = new Reserve("8076", date, 145000, itinerary);

        repoReserve.save(reserve);
        repoReserve.save(reserve1);
        repoReserve.save(reserve2);

        repoReserve.flush();

        assertEquals(4, repoReserve.findAll().size());
    }
}
