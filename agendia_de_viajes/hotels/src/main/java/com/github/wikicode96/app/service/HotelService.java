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

    /**
     * Obtiene todos los hoteles disponibles.
     *
     * @return Lista de hoteles.
     */
    @Override
    public List<Hotel> getAllHotels() {
        return repository.findAll();
    }

    /**
     * Obtiene una lista de hoteles por nombre.
     *
     * @param name Nombre del hotel a buscar.
     * @return Lista de hoteles con el nombre especificado.
     */
    @Override
    public List<Hotel> getHotelByName(String name) {
        return repository.findByName(name);
    }
}
