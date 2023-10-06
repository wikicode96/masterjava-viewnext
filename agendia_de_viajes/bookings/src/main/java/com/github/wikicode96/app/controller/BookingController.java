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

    @PostMapping(value = "booking", consumes = MediaType.APPLICATION_JSON_VALUE)
    String addBooking(@RequestBody Booking booking){
        return service.addBooking(booking);
    }

    @GetMapping(value = "booking/{hotel-name}")
    List<Booking> getBookingsByHotelName(@PathVariable("hotel-name") String hotelName){
        return service.getBookingsByHotelName(hotelName);
    }
}
