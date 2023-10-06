package com.github.wikicode96.app.controller;

import com.github.wikicode96.app.model.Booking;
import com.github.wikicode96.app.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    IBookingService service;

    @PostMapping(value = "booking", consumes = MediaType.APPLICATION_JSON_VALUE)
    String addBooking(@RequestBody Booking booking){
        return service.addBooking(booking);
    }
}
