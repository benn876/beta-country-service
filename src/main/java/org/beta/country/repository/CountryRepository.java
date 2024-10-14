package org.beta.country.repository;

import org.beta.country.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    List<Country> findAllByContinentAndPopulationGreaterThan(String continent, long population);
}
