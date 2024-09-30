package org.beta.country.model;

import lombok.Builder;

import java.util.List;

@Builder
public record Country(
        String name,
        String capital,
        Integer population,
        Integer area,
        String continent,
        List<String> neighbours
) {
}
