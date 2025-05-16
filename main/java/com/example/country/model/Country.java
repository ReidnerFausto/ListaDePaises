package com.example.country.model;

public class Country {
    private String name;
    private String capital;
    private String continent;
    private String flagUrl;

    public Country(String name, String capital, String continent, String flagUrl) {
        this.name = name;
        this.capital = capital;
        this.continent = continent;
        this.flagUrl = flagUrl;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getContinent() {
        return continent;
    }

    public String getFlagUrl() {
        return flagUrl;
    }
}
