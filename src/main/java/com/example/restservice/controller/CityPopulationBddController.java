package com.example.restservice.controller;

import com.example.restservice.entity.CityPopulation;
import com.example.restservice.service.cityPopulationServiceImpl.CityPopulationServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bdd/population")
public class CityPopulationBddController {

    private final CityPopulationServiceImpl cityPopulationService;

    public CityPopulationBddController(CityPopulationServiceImpl cityPopulationService) {
        this.cityPopulationService = cityPopulationService;
    }

    @GetMapping("/{cityName}")
    public CityPopulation getCityPopulationFromBdd(@PathVariable String cityName) {
        return cityPopulationService.getCityPopulationFromBdd(cityName);
    }
}
