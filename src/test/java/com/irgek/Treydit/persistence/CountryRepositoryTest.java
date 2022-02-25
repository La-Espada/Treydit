package com.irgek.Treydit.persistence;

import com.irgek.Treydit.domain.Country;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CountryRepositoryTest {
    @Autowired
    private CountryRepository countryRepository;

    @Test
    void ensureSavingWorksProperly(){
        Country austria = Country.builder()
                .name("Austria")
                .iso2Code("43")
                .build();

        var saved = countryRepository.save(austria);
        assertThat(saved).isSameAs(austria);
    }
}
