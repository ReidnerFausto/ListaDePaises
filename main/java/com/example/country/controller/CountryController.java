package com.example.country.controller;

import com.example.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public String listCountries(@RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String continent,
            Model model) {
        model.addAttribute("countries", countryService.getAll(sortBy, continent));
        return "countries";
    }
}
