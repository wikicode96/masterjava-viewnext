package com.github.wikicode96.app.repository;

import com.github.wikicode96.app.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    List<Hotel> findByNombre(String nombre);
}
