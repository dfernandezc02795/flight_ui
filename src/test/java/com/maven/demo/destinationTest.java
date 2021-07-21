package com.maven.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.maven.demo.model.Destination;
import com.maven.demo.repository.destinationRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class destinationTest {

    @Autowired
    private destinationRepository repoDestination;

    @Test
    public void saveDestination() {
        Destination destination = new Destination("Armenia");

        repoDestination.save(destination);

        repoDestination.flush();

        assertEquals(1, repoDestination.findAll().size());
    }

    @Test
    public void getDestinations() {
        Destination destination = new Destination("Armenia");
        Destination destination1 = new Destination("Cali");
        Destination destination2 = new Destination("Meta");

        repoDestination.save(destination);
        repoDestination.save(destination1);
        repoDestination.save(destination2);

        repoDestination.flush();

        assertEquals(3, repoDestination.findAll().size());
    }
    
}
