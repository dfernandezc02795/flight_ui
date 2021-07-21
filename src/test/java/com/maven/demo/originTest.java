package com.maven.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.maven.demo.model.Origin;
import com.maven.demo.repository.originRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class originTest {

    @Autowired
    private originRepository repoOrigin;

    @Test
    public void saveOrigin() {
        Origin origin = new Origin("Armenia");

        repoOrigin.save(origin);

        repoOrigin.flush();

        assertEquals(1, repoOrigin.findAll().size());
    }
    @Test
    public void getOrigins() {
        Origin origin = new Origin("Armenia");
        Origin origin1 = new Origin("MEdellin");
        Origin origin2 = new Origin("Bogota");

        repoOrigin.save(origin);
        repoOrigin.save(origin1);
        repoOrigin.save(origin2);

        repoOrigin.flush();

        assertEquals(3, repoOrigin.findAll().size());
    }
}
