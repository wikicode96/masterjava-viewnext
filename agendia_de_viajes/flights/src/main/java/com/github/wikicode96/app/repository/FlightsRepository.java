package com.github.wikicode96.app.repository;

import com.github.wikicode96.app.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightsRepository extends JpaRepository<Flight, Integer> {

    /**
     * Recupera una lista de vuelos con un número mínimo de asientos requeridos.
     *
     * @param requiredSeats Número mínimo de asientos requeridos.
     * @return Una lista de vuelos que cumplen con el requisito de asientos.
     */
    @Query("SELECT f FROM Flight f WHERE f.seats >= :requiredSeats")
    List<Flight> findFlightsWithSufficientSeats(@Param("requiredSeats") int requiredSeats);
}
