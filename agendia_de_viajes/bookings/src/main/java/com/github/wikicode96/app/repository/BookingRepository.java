package com.github.wikicode96.app.repository;

import com.github.wikicode96.app.model.Booking;
import com.github.wikicode96.app.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    /**
     * Busca y devuelve una lista de reservas de hotel para un hotel específico.
     *
     * @param hotelId El identificador del hotel para el que se desean obtener las reservas.
     * @return Una lista de reservas de hotel para el hotel especificado.
     */
    List<Booking> findByHotelId(int hotelId);
}
