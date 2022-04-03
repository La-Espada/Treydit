package com.irgek.Treydit.service.dto;

import com.irgek.Treydit.domain.Country;

import java.time.LocalDateTime;

public record CountryDto(Long id, String name, String iso2Code, LocalDateTime created, LocalDateTime updated) {
    public CountryDto(Country country){
        this(country.getId(), country.getName(), country.getIso2Code(),country.getCreated(),country.getUpdated());
    }
}
