package com.github.wikicode96.app.repository;

import com.github.wikicode96.app.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    Hotel findByNombre(String nombre);
}
