package com.irgek.persistence;

import com.irgek.domain.Country;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CountryRepositoryCustom {
    Country addCountry(Country country);
    Country getByName(String name);
    List<Country> getCountries();
}
