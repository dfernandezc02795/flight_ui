package com.maven.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.maven.demo.model.Seat;
import com.maven.demo.repository.seatRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class seatTest {

    @Autowired
    private seatRepository repoSeat;

    @Test
    public void saveSeat() {

        Seat seat = new Seat(2, "A", "Centro", "Alta");

        repoSeat.save(seat);

        repoSeat.flush();

        assertEquals(1, repoSeat.findAll().size());
    }
    @Test
    public void getSeats() {

        Seat seat = new Seat(2, "A", "Centro", "Alta");
        Seat seat1 = new Seat(2, "A", "Centro", "Alta");
        Seat seat2 = new Seat(2, "A", "Centro", "Alta");

        repoSeat.save(seat);
        repoSeat.save(seat1);
        repoSeat.save(seat2);

        repoSeat.flush();

        assertEquals(3, repoSeat.findAll().size());
    }

    @Test
    public void deleteSeat() {
        Seat seat = new Seat(2, "A", "Centro", "Alta");
        Seat seat1 = new Seat(2, "A", "Centro", "Alta");
        Seat seat2 = new Seat(2, "A", "Centro", "Alta");

        repoSeat.save(seat);
        repoSeat.save(seat1);
        repoSeat.save(seat2);

        repoSeat.delete(seat);

        repoSeat.flush();

        assertEquals(2, repoSeat.findAll().size());
    }
}
