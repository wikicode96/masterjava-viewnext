package com.github.wikicode96.app.repository;

import com.github.wikicode96.app.model.Booking;
import com.github.wikicode96.app.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findByHotelId(int hotelId);
}
