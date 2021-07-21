package com.maven.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.maven.demo.model.Rate;
import com.maven.demo.repository.rateRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class rateTest {

    @Autowired
    private rateRepository repoRate;

    @Test
    public void saveRate() {
        Rate rate = new Rate("VIP02", 500000);

        repoRate.save(rate);

        repoRate.flush();

        assertEquals(1, repoRate.findAll().size());
    }
    
    @Test
    public void getRates() {
        Rate rate = new Rate("VIP02", 500000);
        Rate rate1 = new Rate("VIP03", 500000);
        Rate rate2 = new Rate("VIP04", 500000);

        repoRate.save(rate);
        repoRate.save(rate1);
        repoRate.save(rate2);

        repoRate.flush();

        assertEquals(3, repoRate.findAll().size());
    }
}
