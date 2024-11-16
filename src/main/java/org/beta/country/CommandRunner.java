package org.beta.country;

import lombok.RequiredArgsConstructor;
import org.beta.country.model.City;
import org.beta.country.model.Country;
import org.beta.country.model.President;
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
        String romaninanId = UUID.randomUUID().toString();
        countryRepository.saveAll(List.of(
                Country.builder()
                        .id(romaninanId)
                        .name("Romania")
                        .capital("Oradea")
                        .population(19000000)
                        .area(238397)
                        .continent("Europe")
                        .president(President.builder()
                                .id(UUID.randomUUID().toString())
                                .name("Ceausescu")
                                .countryId(romaninanId)
                                .build())
                        .cities(List.of(
                                City.builder()
                                        .id(UUID.randomUUID().toString())
                                        .name("Timisoara")
                                        .build(),
                                City.builder()
                                        .id(UUID.randomUUID().toString())
                                        .name("Cluj")
                                        .build()
                        ))
                        .build(),
                Country.builder()
                        .id(UUID.randomUUID().toString())
                        .name("Franta")
                        .capital("Paris")
                        .population(40000000)
                        .area(551397)
                        .continent("Europe")
                        .build(),
                Country.builder()
                        .id(UUID.randomUUID().toString())
                        .name("China")
                        .capital("Paris")
                        .population(300000000)
                        .area(551397)
                        .continent("Asia")
                        .build()
        ));
    }
}
