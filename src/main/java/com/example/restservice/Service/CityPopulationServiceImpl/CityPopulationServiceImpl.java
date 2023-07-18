package com.example.restservice.Service.CityPopulationServiceImpl;
import com.example.restservice.Dao.CityPopulationDao;
import com.example.restservice.Model.CityPopulation;
import com.example.restservice.Service.CityPopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CityPopulationServiceImpl implements CityPopulationService {
    private CityPopulationDao cityPopulationDao;

    @Autowired
    public CityPopulationServiceImpl(CityPopulationDao cityPopulationDao) {
        this.cityPopulationDao = cityPopulationDao;
    }

    @Override
    public CityPopulation getCityPopulation(String cityName) {
      return cityPopulationDao.getCityPopulation(cityName);
    }
}
