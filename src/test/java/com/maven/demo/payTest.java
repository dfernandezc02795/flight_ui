package com.maven.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import com.maven.demo.model.Country;
import com.maven.demo.model.Passenger;
import com.maven.demo.model.Pay;
import com.maven.demo.repository.countryRepository;
import com.maven.demo.repository.passengerRepository;
import com.maven.demo.repository.payRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class payTest {

    @Autowired
    private payRepository repoPay;

    @Autowired
    private passengerRepository repoPassenger;

    @Autowired
    private countryRepository repoCountry;

    LocalDate date = LocalDate.parse("2000-10-30");

    @Test
    public void savePay() {
        Country country = new Country("Colombia");
        repoCountry.save(country);
        country = repoCountry.save(country);

        Passenger passenger = new Passenger(date, country, "dfc@gmail.com", "Fernandez", "Daniela", "1234", "4321",
                "CC");
        passenger = repoPassenger.save(passenger);

        Pay pay = new Pay(date, 100000, "typeVoucher", "Hd0012", passenger);

        repoPay.save(pay);

        repoPay.flush();

        assertEquals(1, repoPay.findAll().size());
    }
    
    @Test
    public void getPay() {
        Country country = new Country("Colombia");
        repoCountry.save(country);
        country = repoCountry.save(country);

        Passenger passenger = new Passenger(date, country, "dfc@gmail.com", "Fernandez", "Daniela", "1234", "4321",
                "CC");
        passenger = repoPassenger.save(passenger);

        Pay pay = new Pay(date, 100000, "typeVoucher", "Hd0012", passenger);
        Pay pay1 = new Pay(date, 100000, "typeVoucher", "Hd0013", passenger);
        Pay pay2 = new Pay(date, 100000, "typeVoucher", "Hd0014", passenger);

        repoPay.save(pay);
        repoPay.save(pay1);
        repoPay.save(pay2);

        repoPay.flush();

        assertEquals(3, repoPay.findAll().size());
    }
}
