package com.example.restservice.service;


import com.example.restservice.entity.CityPopulation;

public interface CityPopulationService {
    public CityPopulation getCityPopulationFromApi(String cityName);
    public CityPopulation getCityPopulationFromBdd(String cityName);
}
