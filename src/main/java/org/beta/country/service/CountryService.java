package org.beta.country.service;

import org.beta.country.model.Country;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CountryService {
    private List<Country> countries = new ArrayList<>();

    public void setCountries(List<Country> countries) {
        this.countries.addAll(countries);
    }

    public List<Country> getCountries() {
        return countries;
    }

    public Country addCountry(Country country) {
        Country newCountry = country.withId(UUID.randomUUID().toString());
        countries.add(newCountry);
        return newCountry;
    }

    public Country deleteCountry(String id) {
        Country countryToBeDeleted = getCountryById(id);
        countries.remove(countryToBeDeleted);
        return countryToBeDeleted;
    }

    public Country getCountryById(String id) {
        return countries.stream()
                .filter(country -> id.equals(country.id()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Country not found"));
    }

    public List<Country> getCountriesByFilter(String continent, String population) {
        if (continent == null || population == null) {
            return List.of();
        }

        return countries.stream()
                .filter(country -> continent.equals(country.continent()))
                .toList();
    }
}
