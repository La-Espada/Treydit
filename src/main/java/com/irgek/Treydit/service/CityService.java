package com.irgek.Treydit.service;

import com.irgek.Treydit.domain.City;
import com.irgek.Treydit.domain.Country;
import com.irgek.Treydit.persistence.CityRepository;
import com.irgek.Treydit.service.Exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class CityService {

    private final CityRepository cityRepository;
    private String CANNOT_BE_NULL = "cannot be null!";
    private String CANNOT_BE_EMPTY_OR_BLANK = "cannot be empty or blank!";

    public City createCity(String name, Country country){
        City newCity = null;

        if(name == null){
            throw new IllegalArgumentException("Name " + CANNOT_BE_NULL);
        }
        else if (name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("Name " + CANNOT_BE_EMPTY_OR_BLANK);
        }
        else if(country == null){
            throw new IllegalArgumentException("Country " + CANNOT_BE_NULL);
        }
        try {
            var city = cityRepository.findCityByName(name);
            if(city.isPresent()){
                return city.get();
            }
            newCity = City.builder()
                    .name(name)
                    .country(country)
                    .build();
            return cityRepository.save(newCity);
        }
        catch(PersistenceException pEx){
            throw ServiceException.cannotCreateEntity(newCity,pEx);
        }
    }

    public List<City> getCities(){
        return cityRepository.findAll();
    }

    public Optional<City> getCitybyId(Long id){
        return  cityRepository.findCityById(id);
    }
}
