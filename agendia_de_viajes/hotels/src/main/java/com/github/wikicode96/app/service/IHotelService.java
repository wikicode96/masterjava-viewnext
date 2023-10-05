package com.github.wikicode96.app.service;

import com.github.wikicode96.app.model.Hotel;

import java.util.List;

public interface IHotelService {

    List<Hotel> getAllHotels();
    List<Hotel> getHotelByName(String name);
}
