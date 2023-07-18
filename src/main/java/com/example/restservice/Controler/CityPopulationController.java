package com.example.restservice.Controler;

import com.example.restservice.Model.CityPopulation;
import com.example.restservice.Service.CityPopulationServiceImpl.CityPopulationServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/population")
public class CityPopulationController {

    private final CityPopulationServiceImpl cityPopulationService;

    public CityPopulationController(CityPopulationServiceImpl cityPopulationService) {
        this.cityPopulationService = cityPopulationService;
    }

    @GetMapping("/{cityName}")
    public CityPopulation getCityPopulation(@PathVariable String cityName) {
        return cityPopulationService.getCityPopulation(cityName);
    }
}
