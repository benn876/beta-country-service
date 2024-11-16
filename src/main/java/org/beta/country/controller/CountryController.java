package org.beta.country.controller;

import lombok.RequiredArgsConstructor;
import org.beta.country.client.CountryDTO;
import org.beta.country.client.CountryMapper;
import org.beta.country.model.Country;
import org.beta.country.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.beta.country.client.CountryMapper.toDto;

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
    public List<CountryDTO> getCountries() {
        return countryService.getCountries().stream()
                .map(CountryMapper::toDto)
                .toList();
    }

    // http://localhost:8080/countries
    @PostMapping
    public CountryDTO addCountry(@RequestBody Country country) {
        return toDto(countryService.addCountry(country));
    }

    // http://localhost:8080/countries/filter
    @GetMapping("filter")
    public List<CountryDTO> getCountriesFilter(@RequestParam(required = false) String continent,
                                               @RequestParam(required = false) String population) {
        return countryService.getCountriesByFilter(continent, population).stream()
                .map(CountryMapper::toDto)
                .toList();
    }

    @GetMapping("{id}")
    public CountryDTO getCountry(@PathVariable String id) {
        return toDto(countryService.getCountryById(id));
    }

    // http://localhost:8080/countries/{id}
    @DeleteMapping("{id}")
    public CountryDTO deleteCountry(@PathVariable String id) {
        return toDto(countryService.deleteCountry(id));
    }
}
