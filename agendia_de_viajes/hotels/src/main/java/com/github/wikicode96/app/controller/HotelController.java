package com.github.wikicode96.app.controller;

import com.github.wikicode96.app.model.Hotel;
import com.github.wikicode96.app.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelController {

    @Autowired
    IHotelService service;

    @GetMapping(value = "hotels", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Hotel> getAllHotels(){
        return service.getAllHotels();
    }

    @GetMapping(value = "hotel/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Hotel getHotelByName(@PathVariable("name") String name){
        // TODO: Controlar exepciones si encuentra o no hotel
        return service.getHotelByName(name);
    }
}
