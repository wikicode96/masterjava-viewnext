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

    /**
     * Maneja la solicitud GET para mostrar el formulario de creación de una nueva reserva de hotel.
     *
     * @return La vista "new-booking".
     */
    @GetMapping("/new-booking")
    public String formVewBooking(){
        return "new-booking";
    }

    /**
     * Maneja la solicitud POST para agregar una nueva reserva de hotel.
     *
     * @param customerName Nombre del cliente.
     * @param customers    Cantidad de clientes.
     * @param dni          DNI del cliente.
     * @param hotelId      ID del hotel.
     * @param flightId     ID del vuelo.
     * @return La vista "added-booking" después de agregar la reserva.
     */
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

    /**
     * Maneja la solicitud GET para mostrar el formulario de búsqueda de reservas por nombre de hotel.
     *
     * @return La vista "form-booking-by-hotel-name".
     */
    @GetMapping("/form-booking-by-hotel-name")
    public String formBookingsByHotelName(){
        return "form-booking-by-hotel-name";
    }

    /**
     * Maneja la solicitud POST para obtener las reservas por nombre de hotel y mostrarlas en una lista.
     *
     * @param model     Modelo de datos para la vista.
     * @param hotelName Nombre del hotel para buscar reservas.
     * @return La vista "bookings-list" con las reservas encontradas.
     */
    @PostMapping("/booking-by-hotel-name")
    public String getBookingsByHotelName(Model model, @RequestParam("hotelName") String hotelName){
        List<Booking> bookings = service.getBookingsByHotelName(hotelName);
        model.addAttribute("bookings", bookings);
        return "bookings-list";
    }
}
