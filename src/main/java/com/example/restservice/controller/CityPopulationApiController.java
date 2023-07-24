package com.example.restservice.controller;

import com.example.restservice.entity.CityPopulation;
import com.example.restservice.service.cityPopulationServiceImpl.CityPopulationServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/population")
public class CityPopulationApiController {

    private final CityPopulationServiceImpl cityPopulationService;

    public CityPopulationApiController(CityPopulationServiceImpl cityPopulationService) {
        this.cityPopulationService = cityPopulationService;
    }

    @GetMapping("/{cityName}")
    public CityPopulation getCityPopulationFromApi(@PathVariable String cityName) {
        return cityPopulationService.getCityPopulationFromApi(cityName);
    }
}
