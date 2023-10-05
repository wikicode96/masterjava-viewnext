package com.github.wikicode96.app.service;

import com.github.wikicode96.app.model.Booking;

import java.util.List;

public interface IBookingService {

    String addBooking(Booking booking);
    List<Booking> getBookingsByHotelName(String hotelName);
}
