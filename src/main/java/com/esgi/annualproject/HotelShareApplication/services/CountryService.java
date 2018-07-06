package com.esgi.annualproject.HotelShareApplication.services;

import com.esgi.annualproject.HotelShareApplication.entities.Country;
import com.esgi.annualproject.HotelShareApplication.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Transactional(readOnly = true)
    public List<Country> getAll() {
        List<Country> countries = countryRepository.findAll();
        return countries;
    }

    @Transactional(readOnly = true)
    public Country findById(Long id) {
        if(id == null) {
            return null;
        }
        Country country = countryRepository.getOne(id);
        return country;
    }

    @Transactional
    public Country create(Country country) {
        Country persistedCountry = countryRepository.save(country);
        return persistedCountry;
    }

    @Transactional
    public Country deleteById(Long id) {
        Country country = findById(id);
        if(country != null) {
            countryRepository.delete(country);
        }
        return country;
    }

    @Transactional
    public Country updateById(Long id, Country newCountry) {
        Country oldCountry = findById(id);

        if(oldCountry != null) {
            oldCountry.setIdCountry(oldCountry.getIdCountry());
            newCountry = create(newCountry);
        }
        else {
            newCountry = null;
        }
        return newCountry;
    }
}
