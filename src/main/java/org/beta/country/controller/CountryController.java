package org.beta.country.controller;

import lombok.RequiredArgsConstructor;
import org.beta.country.model.Country;
import org.beta.country.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("countries")
public class CountryController {
    private final CountryService countryService;

    // http://localhost:8080/countries/hello
    @GetMapping("hello")
    public String sayHello() {
        return "Hello World";
    }

    // http://localhost:8080/countries
    @GetMapping
    public List<Country> getCountries() {
        return countryService.getCountries();
    }

    // http://localhost:8080/countries/filter
    @GetMapping("filter")
    public List<Country> getCountriesFilter(@RequestParam(required = false) String continent,
                                            @RequestParam(required = false) String population) {
        return countryService.getCountriesByFilter(continent,population);
    }

    @GetMapping("{id}")
    public Country getCountry(@PathVariable String id) {
        return countryService.getCountryById(id);
    }

    // http://localhost:8080/countries
    @PostMapping
    public Country addCountry(@RequestBody Country country) {
        return countryService.addCountry(country);
    }

    // http://localhost:8080/countries/{id}
    @DeleteMapping("{id}")
    public Country deleteCountry(@PathVariable String id){
        return countryService.deleteCountry(id);
    }
}
