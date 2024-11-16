package org.beta.country.client;

import org.beta.country.model.Country;

public class CountryMapper {

    public static CountryDTO toDto(Country country) {
        return CountryDTO.builder()
                .id(country.getId())
                .name(country.getName())
                .capital(country.getCapital())
                .president(country.getPresident())
                .cities(country.getCities())
                .build();
    }
}
