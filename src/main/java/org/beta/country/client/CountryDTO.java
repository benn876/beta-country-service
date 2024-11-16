package org.beta.country.client;

import lombok.Builder;
import org.beta.country.model.City;
import org.beta.country.model.President;

import java.util.List;

@Builder
public record CountryDTO(
        String id,
        String name,
        String capital,
        President president,
        List<City> cities
) {
}
