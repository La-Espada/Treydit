package com.irgek.Treydit.service;

import com.irgek.Treydit.domain.Country;
import com.irgek.Treydit.persistence.CountryRepository;
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
public class CountryService {

    private final CountryRepository countryRepository;
    private String CANNOT_BE_NULL = "cannot be null!";
    private String CANNOT_BE_EMPTY_OR_BLANK = "cannot be empty or blank!";
    private String CANNOT_BE_BLANK = "cannot be blank!";

    public Country createCountry(String name,String iso2Code){
        Country newCountry = null;

        if(name == null){
            throw new IllegalArgumentException("Name " + CANNOT_BE_NULL);
        }
        else if (name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("Name " + CANNOT_BE_EMPTY_OR_BLANK);
        }
        else if(iso2Code == null){
            throw new IllegalArgumentException("iso2Code " + CANNOT_BE_NULL);
        }
        else if (iso2Code.isBlank() || iso2Code.isEmpty()) {
            throw new IllegalArgumentException("iso2Code " + CANNOT_BE_EMPTY_OR_BLANK);
        }
        try {
            var country = countryRepository.findCountryByName(name);
            if(country.isPresent()){
                return country.get();
            }
            newCountry = Country.builder()
                    .name(name)
                    .iso2Code(iso2Code)
                    .build();

            return countryRepository.save(newCountry);
        }
        catch(PersistenceException pEx){
            throw ServiceException.cannotCreateEntity(newCountry,pEx);
        }
    }

    public List<Country> getCountries(){
        return  countryRepository.findAll();
    }

    public Country getCountryById(Long id){
        return  countryRepository.findCountryById(id);
    }

}
