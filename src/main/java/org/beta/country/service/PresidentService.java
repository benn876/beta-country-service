package org.beta.country.service;

import lombok.RequiredArgsConstructor;
import org.beta.country.model.Country;
import org.beta.country.model.President;
import org.beta.country.repository.CountryRepository;
import org.beta.country.repository.PresidentRepository;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.UUID.randomUUID;

@Component
@RequiredArgsConstructor
public class PresidentService {
    private final PresidentRepository presidentRepository;
    private final CountryRepository countryRepository;

    public List<President> getAll() {
        return presidentRepository.findAll();
    }

    public President createPresident(President newPresident) {
        President president = presidentRepository.save(newPresident.withId(randomUUID().toString()));
        Country country = countryRepository.findById(newPresident.getCountryId())
                .orElseThrow(() -> new RuntimeException("Country not found"));
        countryRepository.save(country.withPresident(president));
        return president;
    }
}
