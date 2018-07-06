package com.esgi.annualproject.HotelShareApplication.controllers;

import com.esgi.annualproject.HotelShareApplication.entities.Country;
import com.esgi.annualproject.HotelShareApplication.exceptions.InvalidException;
import com.esgi.annualproject.HotelShareApplication.exceptions.NotFoundException;
import com.esgi.annualproject.HotelShareApplication.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    protected CountryService countryService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Country create(@RequestBody @Valid Country country, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            throw new InvalidException();
        }
        return countryService.create(country);
    }

    @GetMapping("/")
    public List<Country> getAll() {
        return countryService.getAll();
    }

    @GetMapping("/{id}")
    public Country getById(@PathVariable("id") Long id) {
        Country country = countryService.findById(id);
        if (country == null) {
            throw new NotFoundException();
        }
        return country;
    }

    @PutMapping("/{id}")
    public Country updateById(@PathVariable("id") Long id, @RequestBody @Valid Country newCountry, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            throw new InvalidException();
        }
        return countryService.updateById(id, newCountry);
    }

    @DeleteMapping("/{id}")
    public Country deleteById(@PathVariable("id") Long id) {
        Country country = countryService.deleteById(id);
        if (country == null) {
            throw new NotFoundException();
        }
        return country;
    }
}
