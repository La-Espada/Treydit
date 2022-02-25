package com.irgek.Treydit.service;

import com.irgek.Treydit.domain.City;
import com.irgek.Treydit.domain.Country;
import com.irgek.Treydit.persistence.CityRepository;
import com.irgek.Treydit.service.Exception.ServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.PersistenceException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DataJpaTest
public class CityServiceTest {
    @Autowired
    private CityRepository cityRepository;
    private CityService cityService;

    @BeforeEach
    void seup(){
        cityRepository = mock(CityRepository.class);
        cityService = new CityService(cityRepository);
    }

    @Test
    void ensureCreatingCityWithExceptionHandlingIsRight(){
        Country austria = Country.builder()
                .name("Austria")
                .iso2Code("43")
                .build();

        City city = City.builder()
                .name("Vienna")
                .country(austria)
                .build();

        Exception pEx = new PersistenceException("connection lost");
        when(cityRepository.findCityByName(city.getName())).thenReturn(Optional.empty());
        when(cityRepository.save(any())).thenThrow(pEx);

        var ex = assertThrows(ServiceException.class, ()-> cityService.createCity(city.getName(),austria));

        assertThat(ex).hasMessageContaining("City")
                .hasMessageContaining(city.getName(),austria)
                .hasMessageContaining("database problem")
                .hasRootCause(pEx);
    }
}
