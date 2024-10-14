package org.beta.country.service;

import lombok.RequiredArgsConstructor;
import org.beta.country.model.Country;
import org.beta.country.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static java.lang.Long.parseLong;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository repository;

    public List<Country> getCountries() {
        return repository.findAll();
    }

    public Country addCountry(Country country) {
        Country newCountry = country.withId(UUID.randomUUID().toString());
        return repository.save(newCountry);
    }


    public Country deleteCountry(String id) {
        Country countryToBeDeleted = getCountryById(id);
        repository.deleteById(id);
        return countryToBeDeleted;
    }

    public Country getCountryById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found"));
    }

    public List<Country> getCountriesByFilter(String continent, String population) {
        if (continent != null && population != null) {
            return repository.findAllByContinentAndPopulationGreaterThan(continent, parseLong(population));
        }
        return List.of();
    }

}
