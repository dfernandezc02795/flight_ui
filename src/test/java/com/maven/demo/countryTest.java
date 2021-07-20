package com.maven.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.maven.demo.model.Country;
import com.maven.demo.repository.countryRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class countryTest {

    @Autowired
    private countryRepository repoCountry;

    @Test
    public void saveCountry() {
        
        Country country = new Country("Colombia");

        repoCountry.save(country);

        repoCountry.flush();

        assertEquals(1, repoCountry.findAll().size());
    }

    @Test
    public void deleteCountry() {
        Country country = new Country("Colombia");

        repoCountry.save(country);

        repoCountry.flush();

        repoCountry.delete(country);

        assertEquals(0, repoCountry.findAll().size());
    }

    @Test
    public void getCountry() {
        Country country = new Country("Colombia");
        Country country1 = new Country("Portugal");
        Country country2 = new Country("Tokio");
        Country country3 = new Country("Grecia");

        repoCountry.save(country);
        repoCountry.save(country1);
        repoCountry.save(country2);
        repoCountry.save(country3);

        repoCountry.flush();

        assertEquals(4, repoCountry.findAll().size());
    }
    
}
