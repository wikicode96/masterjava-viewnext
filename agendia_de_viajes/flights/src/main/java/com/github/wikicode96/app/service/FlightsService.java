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

    /**
     * Recupera una lista de vuelos disponibles con un número mínimo de asientos requeridos.
     *
     * @param seats Número mínimo de asientos requeridos.
     * @return Una lista de vuelos disponibles que cumplen con el requisito de asientos.
     */
    @Override
    public List<Flight> getAvailablesFlights(int seats) {
        return repository.findFlightsWithSufficientSeats(seats);
    }

    /**
     * Actualiza la cantidad de asientos disponibles en un vuelo específico.
     *
     * @param id    Identificador del vuelo que se va a actualizar.
     * @param seats Nueva cantidad de asientos disponibles.
     * @return Un mensaje indicando si la actualización fue exitosa o si no se encontró el vuelo o el valor de los asientos es incorrecto.
     */
    @Override
    public String updateFlight(int id, int seats) {

        // Finding fligth
        Flight flight = repository.findById(id).orElse(null);

        if(flight != null && seats >= 0){

            // Updating flight
            flight.setSeats(seats);
            repository.save(flight);

            return "Successful update";
        }else{
            return "Flight not found or seats is incorrect value";
        }
    }
}
