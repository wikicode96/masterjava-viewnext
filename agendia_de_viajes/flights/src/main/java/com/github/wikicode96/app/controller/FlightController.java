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

    @GetMapping(value = "flights/{seats}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Flight> flightsWithSufficientSeats(@PathVariable("seats") int seats){
        return service.getAvailablesFlights(seats);
    }

    @PutMapping(value = "flight/{id}/{seats}")
    public String updateFlight(@PathVariable("id") int id, @PathVariable("seats") int seats){
        return service.updateFlight(id, seats);
    }
}
