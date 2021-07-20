package com.maven.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import com.maven.demo.model.Airline;
import com.maven.demo.model.Airport;
import com.maven.demo.model.Country;
import com.maven.demo.model.Destination;
import com.maven.demo.model.Flight;
import com.maven.demo.model.Itinerario;
import com.maven.demo.model.Origin;
import com.maven.demo.model.Plane;
import com.maven.demo.model.Rate;
import com.maven.demo.model.Reserve;
import com.maven.demo.model.Seat;
import com.maven.demo.repository.airlineRepository;
import com.maven.demo.repository.airportRepository;
import com.maven.demo.repository.countryRepository;
import com.maven.demo.repository.destinationRepository;
import com.maven.demo.repository.flightRepository;
import com.maven.demo.repository.itineraryRepository;
import com.maven.demo.repository.originRepository;
import com.maven.demo.repository.planeRepository;
import com.maven.demo.repository.rateRepository;
import com.maven.demo.repository.reserveRepository;
import com.maven.demo.repository.seatRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class flightTest {

    @Autowired
    private countryRepository repoCountry;

    @Autowired
    private airportRepository repoAirport;

    @Autowired
    private airlineRepository repoAirline;

    @Autowired
    private planeRepository repoPlane;

    @Autowired
    private rateRepository repoRate;

    @Autowired
    private reserveRepository repoReserve;

    @Autowired
    private originRepository repoOrigin;

    @Autowired
    private destinationRepository repoDestination;

    @Autowired
    private itineraryRepository repoItinary;

    @Autowired
    private seatRepository repoSeat;

    @Autowired
    private flightRepository repoFlight;

    LocalDate date = LocalDate.parse("2000-10-30");

    LocalTime time = LocalTime.parse("12:00:00");

    @Test
    public void saveFlight() {

        Country country = new Country("Colombia");
        country = repoCountry.save(country);

        Airport airport = new Airport("Eden", country);
        airport = repoAirport.save(airport);

        Airline airline = new Airline("009007", "Avianca");
        airline = repoAirline.save(airline);

        Plane plane = new Plane("Fc123", 28, airline);
        plane = repoPlane.save(plane);

        Rate rate = new Rate("Alta", 10000);
        rate = repoRate.save(rate);

        Origin origin = new Origin("Armenia");
        origin = repoOrigin.save(origin);

        Destination destination = new Destination("Medellin");
        destination = repoDestination.save(destination);

        Itinerario itinerary = new Itinerario(date, time, origin, destination);
        itinerary = repoItinary.save(itinerary);

        Reserve reserve = new Reserve("001", date, 10000, itinerary);
        reserve = repoReserve.save(reserve);

        Seat seat = new Seat(2, "A", "Centro", "Alta");
        seat = repoSeat.save(seat);

        Flight flight = new Flight("001", "Nacional", "Sin novedad", plane, seat, rate, reserve, airport);
        flight = repoFlight.save(flight);

        repoFlight.flush();

        assertEquals(1, repoFlight.findAll().size());
    }

    @Test
    public void getFlights() {
        Country country = new Country("Colombia");
        country = repoCountry.save(country);

        Airport airport = new Airport("Eden", country);
        airport = repoAirport.save(airport);

        Airline airline = new Airline("009007", "Avianca");
        airline = repoAirline.save(airline);

        Plane plane = new Plane("Fc123", 28, airline);
        plane = repoPlane.save(plane);

        Rate rate = new Rate("Alta", 10000);
        rate = repoRate.save(rate);

        Origin origin = new Origin("Armenia");
        origin = repoOrigin.save(origin);

        Destination destination = new Destination("Medellin");
        destination = repoDestination.save(destination);

        Itinerario itinerary = new Itinerario(date, time, origin, destination);
        itinerary = repoItinary.save(itinerary);

        Reserve reserve = new Reserve("001", date, 10000, itinerary);
        reserve = repoReserve.save(reserve);

        Seat seat = new Seat(2, "A", "Centro", "Alta");
        seat = repoSeat.save(seat);

        Flight flight = new Flight("001", "Nacional", "Sin novedad", plane, seat, rate, reserve, airport);

        Flight flight1 = new Flight("002", "Nacional", "Sin novedad", plane, seat, rate, reserve, airport);

        repoFlight.save(flight);
        repoFlight.save(flight1);

        repoFlight.flush();

        assertEquals(2, repoFlight.findAll().size());
    }
}
