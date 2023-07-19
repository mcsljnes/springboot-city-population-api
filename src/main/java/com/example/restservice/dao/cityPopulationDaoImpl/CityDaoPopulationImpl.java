package com.example.restservice.dao.cityPopulationDaoImpl;

import com.example.restservice.dao.CityPopulationDao;
import com.example.restservice.model.CityPopulation;
import com.example.restservice.model.CityPopulationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Repository
public class CityDaoPopulationImpl implements CityPopulationDao {

    @Value("${countriesnow.api.url}")
    private String apiUrl;
    @Override
    public CityPopulation getCityPopulation(String cityName) {
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
            CityPopulationResponse response = responseEntity.getBody();
            if (response != null) {
                return response.getData();
            } else {
                throw new RuntimeException("Erreur lors de l'appel à l'API ou ville introuvable.");
            }
        }

        return null;
    }
}