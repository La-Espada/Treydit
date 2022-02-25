package com.irgek.Treydit.persistence;

import com.irgek.Treydit.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CityRepositoryCustom {
    City addCity(City city);
    City getByName(String name);
    List<City> getCitiesbyCountry(Country country);
}
