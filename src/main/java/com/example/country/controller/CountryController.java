
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
        return "countries";
    }

    @PostMapping("/countries/add")
    public String addCountry(@RequestParam String name,
                             @RequestParam String capital,
                             @RequestParam String continent,
                             @RequestParam String flagUrl) {
        countryService.addCountry(new Country(name, capital, continent, flagUrl));
        return "redirect:/countries";
    }

    @PostMapping("/countries/delete")
    public String deleteCountry(@RequestParam String name) {
        countryService.deleteCountryByName(name);
        return "redirect:/countries";
    }

    @GetMapping("/countries/edit")
    public String editCountry(@RequestParam String name, Model model) {
        Country c = countryService.getByName(name);
        model.addAttribute("country", c);
        return "edit_country";
    }

    @PostMapping("/countries/update")
    public String updateCountry(@RequestParam String originalName,
                                @RequestParam String name,
                                @RequestParam String capital,
                                @RequestParam String continent,
                                @RequestParam String flagUrl) {
        countryService.updateCountry(originalName, new Country(name, capital, continent, flagUrl));
        return "redirect:/countries";
    }
}
