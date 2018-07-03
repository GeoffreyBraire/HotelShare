package com.esgi.annualproject.HotelShareApplication.repositories;

import com.esgi.annualproject.HotelShareApplication.entities.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
