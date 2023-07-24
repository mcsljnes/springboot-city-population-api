package com.example.restservice.dao.cityPopulationDaoImpl;

import com.example.restservice.dao.CityPopulationDao;
import com.example.restservice.entity.CityPopulation;
import com.example.restservice.entity.CityPopulationResponse;
import com.example.restservice.repository.CityPopulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Repository
public class CityDaoPopulationImpl implements CityPopulationDao {

    @Value("${countriesnow.api.url}")
    private String apiUrl;

    @Autowired
    private CityPopulationRepository cityPopulationRepository;

    @Override
    public CityPopulation getCityPopulationFromApi(String cityName) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<CityPopulationResponse> responseEntity = restTemplate.getForEntity(
                apiUrl + "/q?city=" + cityName,
                CityPopulationResponse.class
        );
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            CityPopulationResponse cityPopulationResponse = responseEntity.getBody();
            if (cityPopulationResponse != null) {
                CityPopulation cityPopulation = cityPopulationResponse.getData();
                cityPopulationRepository.save(cityPopulation);

                return cityPopulation;
            } else {
                throw new RuntimeException("Erreur lors de l'appel à l'API ou ville introuvable.");
            }
        }

        return null;
    }

    @Override
    public CityPopulation getCityPopulationFromBdd(String cityName) {
        // Utilise la méthode findByCity de CityPopulationRepository pour récupérer la population d'une ville donnée
        CityPopulation cityPopulation = cityPopulationRepository.findByCity(cityName);

        if (cityPopulation == null) {
            // Gère le cas où la ville n'existe pas dans la base de données
            throw new RuntimeException("Ville introuvable dans la base de données.");
        }

        return cityPopulation;
    }
}