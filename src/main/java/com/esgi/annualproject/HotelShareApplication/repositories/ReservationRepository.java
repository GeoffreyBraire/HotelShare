package com.esgi.annualproject.HotelShareApplication.repositories;

import com.esgi.annualproject.HotelShareApplication.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
