package com.example.country.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Country {

    @Id
    private String name;
    private String capital;
    private String continent;
    private String flagUrl;

    public Country() {
    }

    public Country(String name, String capital, String continent, String flagUrl) {
        this.name = name;
        this.capital = capital;
        this.continent = continent;
        this.flagUrl = flagUrl;
    }

    // Getters e Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getFlagUrl() {
        return flagUrl;
    }

    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl;
    }
}
