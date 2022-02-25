package com.irgek.Treydit.persistence;

import com.irgek.Treydit.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CountryRepositoryCustom {
    Country addCountry(Country country);
    Country getByName(String name);
    List<Country> getCountries();
}
