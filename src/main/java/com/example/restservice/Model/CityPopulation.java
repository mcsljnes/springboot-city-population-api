package com.example.restservice.Model;

import com.example.restservice.Model.PopulationCount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityPopulation {
    private String city;
    private String country;
    private List<PopulationCount> populationCounts;
}