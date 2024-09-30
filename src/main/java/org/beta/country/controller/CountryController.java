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
    public String sayHello(){
        return "Hello World";
    }

    // http://localhost:8080/countries
    @GetMapping
    public List<Country> getCountries(){
        return countryService.getCountries();
    }

    // http://localhost:8080/countries
    @PostMapping
    public Country addCountry(@RequestBody Country country){
        System.out.println("test");
       return countryService.addCountry(country);
    }

}
