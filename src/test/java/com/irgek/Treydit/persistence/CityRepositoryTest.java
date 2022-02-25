package com.irgek.Treydit.persistence;

import com.irgek.Treydit.domain.City;
import com.irgek.Treydit.domain.Country;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CityRepositoryTest {
    @Autowired
    private CityRepository cityRepository;

    @Test
    void ensureSavingWorksProperly(){
        Country austria = Country.builder()
                .name("Austria")
                .iso2Code("43")
                .build();

        City city = City.builder()
                .name("Vienna")
                .country(austria)
                .build();

        var saved = cityRepository.save(city);
        assertThat(saved).isSameAs(city);
    }
}
