package com.example.restservice.service.cityPopulationServiceImpl;
import com.example.restservice.dao.CityPopulationDao;
import com.example.restservice.entity.CityPopulation;
import com.example.restservice.service.CityPopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CityPopulationServiceImpl implements CityPopulationService {
    private CityPopulationDao cityPopulationDao;

    @Autowired
    public CityPopulationServiceImpl(CityPopulationDao cityPopulationDao) {
        this.cityPopulationDao = cityPopulationDao;
    }

    public CityPopulation getCityPopulationFromApi(String cityName) {
      return cityPopulationDao.getCityPopulationFromApi(cityName);
    }

    public CityPopulation getCityPopulationFromBdd(String cityName) {
        return cityPopulationDao.getCityPopulationFromBdd(cityName);
    }
}
