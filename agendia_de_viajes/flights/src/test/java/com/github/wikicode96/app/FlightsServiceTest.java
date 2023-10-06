package com.github.wikicode96.app;

import com.github.wikicode96.app.model.Flight;
import com.github.wikicode96.app.repository.FlightsRepository;
import com.github.wikicode96.app.service.FlightsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FlightsServiceTest {

    @Mock
    private FlightsRepository repository;

    @InjectMocks
    private FlightsService flightsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAvailablesFlights() {
        int minimumSeats = 3;
        List<Flight> mockFlights = Arrays.asList(new Flight(), new Flight());
        when(repository.findFlightsWithSufficientSeats(minimumSeats)).thenReturn(mockFlights);

        List<Flight> result = flightsService.getAvailablesFlights(minimumSeats);

        assertEquals(2, result.size());
    }

    @Test
    public void testUpdateFlight_SuccessfulUpdate() {
        int flightId = 1;
        int newSeats = 50;
        Flight mockFlight = new Flight();
        when(repository.findById(flightId)).thenReturn(Optional.of(mockFlight));

        String result = flightsService.updateFlight(flightId, newSeats);

        assertEquals("Successful update", result);
        assertEquals(newSeats, mockFlight.getSeats());
        verify(repository, times(1)).save(mockFlight);
    }

    @Test
    public void testUpdateFlight_FlightNotFound() {
        int flightId = 1;
        int newSeats = 50;
        when(repository.findById(flightId)).thenReturn(Optional.empty());

        String result = flightsService.updateFlight(flightId, newSeats);

        assertEquals("Flight not found or seats is incorrect value", result);
    }

    @Test
    public void testUpdateFlight_InvalidSeats() {
        int flightId = 1;
        int newSeats = -10;
        Flight mockFlight = new Flight();
        when(repository.findById(flightId)).thenReturn(Optional.of(mockFlight));

        String result = flightsService.updateFlight(flightId, newSeats);

        assertEquals("Flight not found or seats is incorrect value", result);
        verify(repository, never()).save(mockFlight);
    }
}
