package com.github.wikicode96.app.repository;

import com.github.wikicode96.app.model.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightsRepository extends JpaRepository<Flights, Integer> {
}
