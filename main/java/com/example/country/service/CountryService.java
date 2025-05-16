package com.example.country.service;

import com.example.country.model.Country;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {

    private final List<Country> countries = Arrays.asList(
            new Country("Brasil", "Brasília", "América do Sul", "https://flagcdn.com/w320/br.png"),
            new Country("Canadá", "Ottawa", "América do Norte", "https://flagcdn.com/w320/ca.png"),
            new Country("Alemanha", "Berlim", "Europa", "https://flagcdn.com/w320/de.png"),
            new Country("Japão", "Tóquio", "Ásia", "https://flagcdn.com/w320/jp.png"),
            new Country("África do Sul", "Pretória", "África", "https://flagcdn.com/w320/za.png"),
            new Country("Argentina", "Buenos Aires", "América do Sul", "https://flagcdn.com/w320/ar.png"),
            new Country("Estados Unidos", "Washington, D.C.", "América do Norte", "https://flagcdn.com/w320/us.png"),
            new Country("França", "Paris", "Europa", "https://flagcdn.com/w320/fr.png"),
            new Country("China", "Pequim", "Ásia", "https://flagcdn.com/w320/cn.png"),
            new Country("Egito", "Cairo", "África", "https://flagcdn.com/w320/eg.png"),
            new Country("Índia", "Nova Délhi", "Ásia", "https://flagcdn.com/w320/in.png"),
            new Country("México", "Cidade do México", "América do Norte", "https://flagcdn.com/w320/mx.png"),
            new Country("Reino Unido", "Londres", "Europa", "https://flagcdn.com/w320/gb.png"),
            new Country("Austrália", "Camberra", "Oceania", "https://flagcdn.com/w320/au.png"),
            new Country("Rússia", "Moscou", "Europa/Ásia", "https://flagcdn.com/w320/ru.png"));

    public List<Country> getAll(String sortBy, String continent) {
        return countries.stream()
                .filter(c -> continent == null || continent.isEmpty() || c.getContinent().equalsIgnoreCase(continent))
                .sorted(getComparator(sortBy))
                .collect(Collectors.toList());
    }

    private Comparator<Country> getComparator(String sortBy) {
        if (sortBy == null)
            return Comparator.comparing(Country::getName);
        return switch (sortBy) {
            case "name" -> Comparator.comparing(Country::getName);
            case "capital" -> Comparator.comparing(Country::getCapital);
            case "continent" -> Comparator.comparing(Country::getContinent);
            default -> Comparator.comparing(Country::getName);
        };
    }
}
