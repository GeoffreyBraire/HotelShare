package com.esgi.annualproject.HotelShareApplication.controllers;

import com.esgi.annualproject.HotelShareApplication.entities.Country;
import com.esgi.annualproject.HotelShareApplication.exceptions.ResourceNotFoundException;
import com.esgi.annualproject.HotelShareApplication.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public class CountryController {
    @Autowired
    CountryRepository countryRepository;

    @GetMapping("/countries")
    public Page<Country> getAllCountries(Pageable pageable) {
        return countryRepository.findAll(pageable);
    }

    @PostMapping("/countries")
    public Country createCountry(@Valid @RequestBody Country country) {
        return countryRepository.save(country);
    }

    @PutMapping("/countries/{countryId}")
    public Country updateCountry(@PathVariable Long countryId, @Valid @RequestBody Country countryRequest) {
        return countryRepository.findById(countryId).map(country -> {
            country.setNameCountry(countryRequest.getNameCountry());
            return countryRepository.save(country);
        }).orElseThrow(() -> new ResourceNotFoundException("CountryId " + countryId + " not found"));
    }


    @DeleteMapping("/countries/{countryId}")
    public ResponseEntity<?> deleteCountry(@PathVariable Long countryId) {
        return countryRepository.findById(countryId).map(country -> {
            countryRepository.delete(country);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("CountryId " + countryId + " not found"));
    }
}
