package com.example.restservice.dao;

import com.example.restservice.model.CityPopulation;

public interface CityPopulationDao {
    public CityPopulation getCityPopulation(String cityName);
}
