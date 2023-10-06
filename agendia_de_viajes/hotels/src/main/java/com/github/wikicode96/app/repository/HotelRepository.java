package com.github.wikicode96.app.repository;

import com.github.wikicode96.app.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    /**
     * Busca hoteles por nombre.
     *
     * @param name Nombre del hotel a buscar.
     * @return Lista de hoteles con el nombre especificado.
     */
    List<Hotel> findByName(String name);
}
