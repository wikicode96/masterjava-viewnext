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

    /**
     * Agrega una nueva reserva de hotel.
     *
     * @param booking La reserva de hotel que se va a agregar.
     * @return Un mensaje que indica si la reserva se agregó con éxito o si hubo un problema.
     */
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

    /**
     * Obtiene una lista de reservas de hotel para un hotel específico.
     *
     * @param hotelName El nombre del hotel para el que se desea obtener las reservas.
     * @return Una lista de reservas de hotel para el hotel especificado.
     */
    @Override
    public List<Booking> getBookingsByHotelName(String hotelName) {

        List<Booking> allBookings = new ArrayList<>();

        // Get request hotels by name
        Hotel[] hotels = restTemplate.getForObject(urlHotel + "hotel/" + hotelName, Hotel[].class);

        // Get all booking by hotels id
        for (Hotel h: hotels) {
            List<Booking> dbBooking = repository.findByHotelId(h.getId());

            // Add bookings into the list that will be returned
            for (Booking b: dbBooking) {
                b.setHotel(h);
                allBookings.add(b);
            }
        }

        return allBookings;
    }
}
