package com.esgi.annualproject.HotelShareApplication.controllers;

import com.esgi.annualproject.HotelShareApplication.entities.Address;
import com.esgi.annualproject.HotelShareApplication.exceptions.ResourceNotFoundException;
import com.esgi.annualproject.HotelShareApplication.repositories.AddressRepository;
import com.esgi.annualproject.HotelShareApplication.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/countries")
public class AddressController {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/{countryId}/addresses")
    public Page<Address> getAllAddressesByCountryId(@PathVariable(value = "countryId") Long countryId,
                                                    Pageable pageable) {
        return addressRepository.findByCountryId(countryId, pageable);
    }

    @PostMapping("/{countryId}/addresses")
    public Address createAddress(@PathVariable (value = "countryId") Long countryId,
                                 @Valid @RequestBody Address address) {
        return countryRepository.findById(countryId).map(country -> {
            address.setCountry(country);
            return addressRepository.save(address);
        }).orElseThrow(() -> new ResourceNotFoundException("CountryId " + countryId + " not found"));
    }

    @PutMapping("/{countryId}/addresses/{addressId}")
    public Address updateAddress(@PathVariable (value = "countryId") Long countryId,
                                 @PathVariable (value = "addressId") Long addressId,
                                 @Valid @RequestBody Address addressRequest) {
        if(!countryRepository.existsById(countryId)) {
            throw new ResourceNotFoundException("CountryId " + countryId + " not found");
        }

        return addressRepository.findById(addressId).map(address -> {
            address.setCountry(addressRequest.getCountry());
            return addressRepository.save(address);
        }).orElseThrow(() -> new ResourceNotFoundException("AddressId " + addressId + "not found"));
    }

    @DeleteMapping("/{countryId}/addresses/{addressId}")
    public ResponseEntity<?> deleteAddress(@PathVariable (value = "countryId") Long countryId,
                                           @PathVariable (value = "addressId") Long addressId) {
        if(!countryRepository.existsById(countryId)) {
            throw new ResourceNotFoundException("CountryId " + countryId + " not found");
        }

        return addressRepository.findById(addressId).map(address -> {
            addressRepository.delete(address);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("AddressId " + addressId + " not found"));
    }
}
