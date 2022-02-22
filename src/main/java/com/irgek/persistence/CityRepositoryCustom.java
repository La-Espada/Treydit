package com.irgek.persistence;

import com.irgek.domain.City;
import com.irgek.domain.Country;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CityRepositoryCustom {
    City addCity(City city);
    City getByName(String name);
    List<City> getCitiesbyCountry(Country country);
}
