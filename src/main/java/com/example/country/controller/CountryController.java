package com.example.country.controller;

import com.example.country.model.Country;
import com.example.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public String listCountries(@RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String continent,
            Model model) {
        model.addAttribute("countries", countryService.getAll(sortBy, continent));
        model.addAttribute("newCountry", new Country()); // para o formulário
        return "countries";
    }

    @PostMapping("/countries/add")
    public String addCountry(@ModelAttribute Country country) {
        countryService.addCountry(country);
        return "redirect:/countries";
    }

    @PostMapping("/countries/delete")
    public String deleteCountry(@RequestParam String name) {
        countryService.deleteCountry(name);
        return "redirect:/countries";
    }
}
