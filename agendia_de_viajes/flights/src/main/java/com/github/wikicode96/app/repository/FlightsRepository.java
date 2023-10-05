package com.github.wikicode96.app.repository;

import com.github.wikicode96.app.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightsRepository extends JpaRepository<Flight, Integer> {

    @Query("SELECT f FROM Flights f WHERE f.seats >= :requiredSeats")
    List<Flight> findFlightsWithSufficientSeats(@Param("requiredSeats") int requiredSeats);
}
