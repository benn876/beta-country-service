package org.beta.country;

import lombok.RequiredArgsConstructor;
import org.beta.country.model.Country;
import org.beta.country.service.CountryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommandRunner implements CommandLineRunner {
    private final CountryService countryService;

    @Override
    public void run(String... args) {
        countryService.setCountries(List.of(
                Country.builder()
                        .name("Romania")
                        .capital("Oradea")
                        .population(19000000)
                        .area(238397)
                        .continent("Europe")
                        .neighbours(List.of())
                        .build(),
                Country.builder()
                        .name("Franta")
                        .capital("Paris")
                        .population(40000000)
                        .area(551397)
                        .continent("Europe")
                        .neighbours(List.of())
                        .build()
        ));
    }
}
