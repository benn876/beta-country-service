package org.beta.country.repository;

import org.beta.country.model.President;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresidentRepository extends JpaRepository<President, String> {
}
