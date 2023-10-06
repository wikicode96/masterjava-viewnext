package com.github.wikicode96.app.service;

import com.github.wikicode96.app.model.Booking;
import com.github.wikicode96.app.model.Flight;
import com.github.wikicode96.app.model.Hotel;
import com.github.wikicode96.app.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookingService implements IBookingService{

    @Autowired
    BookingRepository repository;

    @Autowired
    RestTemplate restTemplate;

    private final String urlHotel = "http://localhost:8080/";
    private final String urlFlight = "http://localhost:8081/";

    @Override
    public String addBooking(Booking booking) {

        // Check available flights
        int idFlight = booking.getFlightId();

        Flight[] flights = restTemplate.getForObject(urlFlight + "flights/" + booking.getCustomers(), Flight[].class);

        if (flights != null && flights.length > 0) {
            for (Flight f: flights) {
                if(f.getId() == idFlight && f.getSeats() >= booking.getCustomers()){

                    // Update seats of flight and save booking
                    f.setSeats(f.getSeats() - booking.getCustomers());
                    restTemplate.put(urlFlight + "flight/" + f.getId() + "/" + f.getSeats(), String.class);
                    repository.save(booking);

                    return "successful";
                }
            }
        }

        return "Somenthing was wrong";
    }

    @Override
    public List<Booking> getBookingsByHotelName(String hotelName) {

        List<Booking> allBookings = new ArrayList<>();

        // Get request
        Hotel[] hotels = restTemplate.getForObject(urlHotel + "hotel/" + hotelName, Hotel[].class);

        // Cath all ids by hotels
        Set<Integer> ids = new HashSet<>();
        for (Hotel h: hotels) {
            ids.add(h.getId());
        }

        // Get all booking by hotels id
        for (int id: ids) {
            List<Booking> dbBooking = repository.findByHotelId(id);
            for (Booking b: dbBooking) {
                allBookings.add(b);
            }
        }

        return allBookings;
    }
}
