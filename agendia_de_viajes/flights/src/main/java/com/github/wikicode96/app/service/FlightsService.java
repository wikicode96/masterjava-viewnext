package com.github.wikicode96.app.service;

import com.github.wikicode96.app.model.Flight;
import com.github.wikicode96.app.repository.FlightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightsService implements IFlightsService {

    @Autowired
    FlightsRepository repository;

    @Override
    public List<Flight> getAvailablesFlights(int seats) {
        return repository.findFlightsWithSufficientSeats(seats);
    }

    @Override
    public String updateFlight(int id, int reservedSeats) {

        // Finding fligth
        Flight flight = repository.findById(id).orElse(null);

        // It's null or not have enought seats
        if(flight != null){
            if (flight.getSeats() >= reservedSeats){

                // Updating
                flight.setSeats(flight.getSeats() - reservedSeats);
                repository.save(flight);

                return "Successful update";
            }else{
                return "there are not enough seats";
            }
        }else{
            return "Flight not found";
        }
    }
}
