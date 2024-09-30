package org.beta.country.service;

import org.beta.country.model.Country;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {
    private List<Country> countries = new ArrayList<>();

    public void setCountries(List<Country> countries) {
        this.countries.addAll(countries);
    }

    public List<Country> getCountries() {
        return countries;
    }
}
