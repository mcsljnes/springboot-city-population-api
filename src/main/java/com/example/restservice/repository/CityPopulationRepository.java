package com.example.restservice.repository;

import com.example.restservice.entity.CityPopulation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityPopulationRepository extends JpaRepository<CityPopulation, Long> {
    CityPopulation findByCity(String cityName);
}
