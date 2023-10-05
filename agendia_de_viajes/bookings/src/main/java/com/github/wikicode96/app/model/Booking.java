package com.github.wikicode96.app.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "reservas")
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "customer_name")
    private String customer;
    @Column(name = "customers")
    private int customers;
    @Column(name = "dni")
    private String dni;
    @Column(name = "hotel_id")
    private int hotelId;
    @Column(name = "vuelo_id")
    private int flightId;
    @Transient
    private Flight flight;
    @Transient
    private Hotel hotel;

    public Booking() {
    }

    public Booking(int id, String customer, String dni, int hotelId, int flightId) {
        this.id = id;
        this.customer = customer;
        this.dni = dni;
        this.hotelId = hotelId;
        this.flightId = flightId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id == booking.id && hotelId == booking.hotelId && flightId == booking.flightId && Objects.equals(customer, booking.customer) && Objects.equals(dni, booking.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, dni, hotelId, flightId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getCustomers() {
        return customers;
    }

    public void setCustomers(int customers) {
        this.customers = customers;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
