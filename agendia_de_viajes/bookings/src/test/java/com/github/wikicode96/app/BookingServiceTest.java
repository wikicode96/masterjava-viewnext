package com.github.wikicode96.app;

import com.github.wikicode96.app.model.Booking;
import com.github.wikicode96.app.model.Flight;
import com.github.wikicode96.app.model.Hotel;
import com.github.wikicode96.app.repository.BookingRepository;
import com.github.wikicode96.app.service.BookingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookingServiceTest {

    @InjectMocks
    private BookingService bookingService;

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddBooking_SuccessfulBooking() {
        Flight mockFlight = new Flight(1, "Flight Company", null, 200, 10);
        Flight[] mockFlights = { mockFlight };
        int flightId = 1;

        when(restTemplate.getForObject(anyString(), eq(Flight[].class))).thenReturn(mockFlights);

        Booking booking = new Booking(1, "Customer", "123456", 1, flightId);

        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);

        String result = bookingService.addBooking(booking);

        verify(bookingRepository, times(1)).save(booking);
        verify(restTemplate, times(1)).put(anyString(), eq(String.class));

        assertEquals("Successful", result);
    }
}
