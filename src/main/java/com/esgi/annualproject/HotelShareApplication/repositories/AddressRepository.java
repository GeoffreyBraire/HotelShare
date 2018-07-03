package com.esgi.annualproject.HotelShareApplication.repositories;

import com.esgi.annualproject.HotelShareApplication.entities.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Page<Address> findByCountryId(Long countryId, Pageable pageable);
}
