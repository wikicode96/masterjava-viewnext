package com.github.wikicode96.app.service;

import com.github.wikicode96.app.model.Hotel;
import com.github.wikicode96.app.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService implements IHotelService {

    @Autowired
    HotelRepository repository;

    @Override
    public List<Hotel> getAllHotels() {
        return repository.findAll();
    }

    @Override
    public List<Hotel> getHotelByName(String name) {
        return repository.findByNombre(name);
    }
}
