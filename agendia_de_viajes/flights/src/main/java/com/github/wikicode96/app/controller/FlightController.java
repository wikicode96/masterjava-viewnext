package com.github.wikicode96.app.controller;

import com.github.wikicode96.app.model.Flight;
import com.github.wikicode96.app.service.IFlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightController {

    @Autowired
    IFlightsService service;

    /**
     * Recupera una lista de vuelos disponibles con un número mínimo de asientos requeridos.
     *
     * @param seats Número mínimo de asientos requeridos.
     * @return Una lista de vuelos disponibles que cumplen con el requisito de asientos.
     */
    @GetMapping(value = "flights/{seats}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Flight> flightsWithSufficientSeats(@PathVariable("seats") int seats){
        return service.getAvailablesFlights(seats);
    }

    /**
     * Actualiza la cantidad de asientos disponibles en un vuelo específico.
     *
     * @param id    Identificador del vuelo que se va a actualizar.
     * @param seats Nueva cantidad de asientos disponibles.
     * @return Un mensaje indicando si la actualización fue exitosa o si no se encontró el vuelo o el valor de los asientos es incorrecto.
     */
    @PutMapping(value = "flight/{id}/{seats}")
    public String updateFlight(@PathVariable("id") int id, @PathVariable("seats") int seats){
        return service.updateFlight(id, seats);
    }
}
