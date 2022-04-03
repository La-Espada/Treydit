package com.irgek.Treydit.service.dto;

import com.irgek.Treydit.domain.City;
import com.irgek.Treydit.domain.Country;

import java.time.LocalDateTime;

public record CityDto(Long id, String name, Country country, LocalDateTime created, LocalDateTime updated) {
    public CityDto(City city){
        this(city.getId(),city.getName(),city.getCountry(),city.getCreated(),city.getUpdated());
    }
}
