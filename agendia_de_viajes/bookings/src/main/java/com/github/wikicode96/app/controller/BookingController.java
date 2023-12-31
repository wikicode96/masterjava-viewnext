package com.github.wikicode96.app.controller;

import com.github.wikicode96.app.model.Booking;
import com.github.wikicode96.app.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    IBookingService service;

    /**
     * Agrega una nueva reserva de hotel.
     *
     * @param booking La reserva de hotel que se va a agregar.
     * @return Un mensaje que indica si la reserva se agregó con éxito.
     */
    @PostMapping(value = "booking", consumes = MediaType.APPLICATION_JSON_VALUE)
    String addBooking(@RequestBody Booking booking){
        return service.addBooking(booking);
    }

    /**
     * Obtiene una lista de reservas de hotel para un hotel específico.
     *
     * @param hotelName El nombre del hotel para el que se desea obtener las reservas.
     * @return Una lista de reservas de hotel para el hotel especificado.
     */
    @GetMapping(value = "booking/{hotel-name}")
    List<Booking> getBookingsByHotelName(@PathVariable("hotel-name") String hotelName){
        return service.getBookingsByHotelName(hotelName);
    }
}
