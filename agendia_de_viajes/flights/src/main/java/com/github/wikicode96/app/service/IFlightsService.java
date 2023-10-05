package com.github.wikicode96.app.service;

import com.github.wikicode96.app.model.Flight;

import java.util.List;

public interface IFlightsService {

    List<Flight> getAvailablesFlights(int seats);
    String updateFlight(int id, int reservedSeats);
}
