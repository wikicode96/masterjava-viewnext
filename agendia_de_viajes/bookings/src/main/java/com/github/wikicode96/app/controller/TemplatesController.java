package com.github.wikicode96.app.controller;

import com.github.wikicode96.app.model.Booking;
import com.github.wikicode96.app.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TemplatesController {

    @Autowired
    IBookingService service;

    @GetMapping("/new-booking")
    public String formVewBooking(){
        return "new-booking";
    }

    @PostMapping("/add-booking")
    public String getBookingsByHotelName(@RequestParam("customerName") String customerName,
                                         @RequestParam("customers") int customers,
                                         @RequestParam("dni") String dni,
                                         @RequestParam("hotelId") int hotelId,
                                         @RequestParam("flightId") int flightId){
        Booking booking = new Booking();
        booking.setCustomer(customerName);
        booking.setCustomers(customers);
        booking.setDni(dni);
        booking.setHotelId(hotelId);
        booking.setFlightId(flightId);

        service.addBooking(booking);

        return "added-booking";
    }

    @GetMapping("/form-booking-by-hotel-name")
    public String formBookingsByHotelName(){
        return "form-booking-by-hotel-name";
    }

    @PostMapping("/booking-by-hotel-name")
    public String getBookingsByHotelName(Model model, @RequestParam("hotelName") String hotelName){
        List<Booking> bookings = service.getBookingsByHotelName(hotelName);
        model.addAttribute("bookings", bookings);
        return "bookings-list";
    }
}
