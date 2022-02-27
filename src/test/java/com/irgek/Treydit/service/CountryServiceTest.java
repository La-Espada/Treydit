package com.irgek.Treydit.service;

import com.irgek.Treydit.domain.Country;
import com.irgek.Treydit.persistence.CountryRepository;
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
public class CountryServiceTest {
    @Autowired
    private CountryRepository countryRepository;
    private CountryService countryService;

    @BeforeEach
    void setup(){
        countryRepository = mock(CountryRepository.class);
        countryService = new CountryService(countryRepository);
    }

    @Test
    void ensureCreatingCountryWithExceptionHandlingIsRight(){
        Country austria = Country.builder()
                .name("Austria")
                .iso2Code("43")
                .build();

        Exception pEx = new PersistenceException("connection lost");
        when(countryRepository.findCountryByName(austria.getName())).thenReturn(Optional.empty());
        when(countryRepository.save(any())).thenThrow(pEx);

        var ex = assertThrows(ServiceException.class, ()-> countryService.createCountry(austria.getName(),austria.getIso2Code()));

        assertThat(ex).hasMessageContaining("Country")
                .hasMessageContaining(austria.getName(),austria.getIso2Code())
                .hasMessageContaining("database problem")
                .hasRootCause(pEx);
    }
}
