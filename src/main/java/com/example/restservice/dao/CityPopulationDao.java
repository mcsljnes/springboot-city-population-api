package com.example.restservice.dao;


import com.example.restservice.entity.CityPopulation;

public interface CityPopulationDao {

    public CityPopulation getCityPopulationFromApi(String cityName);
    public CityPopulation getCityPopulationFromBdd(String cityName);

}
