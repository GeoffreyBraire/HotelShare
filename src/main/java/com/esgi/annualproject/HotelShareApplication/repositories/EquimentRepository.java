package com.esgi.annualproject.HotelShareApplication.repositories;

import com.esgi.annualproject.HotelShareApplication.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquimentRepository extends JpaRepository<Equipment, Long> {
}
