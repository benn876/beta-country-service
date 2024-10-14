package org.beta.country;

import lombok.RequiredArgsConstructor;
import org.beta.country.model.Country;
import org.beta.country.repository.CountryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CommandRunner implements CommandLineRunner {
    private final CountryRepository countryRepository;

    @Override
    public void run(String... args) {
        countryRepository.saveAll(List.of(
                Country.builder()
                        .id(UUID.randomUUID().toString())
                        .name("Romania")
                        .capital("Oradea")
                        .population(19000000)
                        .area(238397)
                        .continent("Europe")
                        .neighbours(List.of())
                        .build(),
                Country.builder()
                        .id(UUID.randomUUID().toString())
                        .name("Franta")
                        .capital("Paris")
                        .population(40000000)
                        .area(551397)
                        .continent("Europe")
                        .neighbours(List.of())
                        .build(),
                Country.builder()
                        .id(UUID.randomUUID().toString())
                        .name("China")
                        .capital("Paris")
                        .population(300000000)
                        .area(551397)
                        .continent("Asia")
                        .neighbours(List.of())
                        .build()
        ));
    }
}
