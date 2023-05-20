package com.usc.controller;

import com.usc.dao.CountryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usc.beans.Country;
import com.usc.beans.State;

import java.util.List;
import java.util.Set;

@RestController()
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    CountryDao countryDao;

    @GetMapping
    public List<Country> getCountries() {
        return countryDao.findAll();
    }

    @GetMapping("/{code}")
    public Set<State> getCountryStates(@PathVariable String code) {
        return countryDao.findByCode(code).getStates();
    }

}
