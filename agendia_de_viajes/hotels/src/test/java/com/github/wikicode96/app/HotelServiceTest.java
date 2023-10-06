package com.github.wikicode96.app;

import com.github.wikicode96.app.model.Hotel;
import com.github.wikicode96.app.repository.HotelRepository;
import com.github.wikicode96.app.service.HotelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class HotelServiceTest {

    @Mock
    private HotelRepository repository;

    @InjectMocks
    private HotelService hotelService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllHotels() {
        List<Hotel> mockHotels = Arrays.asList(new Hotel(), new Hotel());
        when(repository.findAll()).thenReturn(mockHotels);

        List<Hotel> result = hotelService.getAllHotels();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetHotelByName() {
        List<Hotel> mockHotels = Arrays.asList(new Hotel(), new Hotel());
        when(repository.findByName("HotelName")).thenReturn(mockHotels);

        List<Hotel> result = hotelService.getHotelByName("HotelName");

        assertEquals(2, result.size());
    }
}