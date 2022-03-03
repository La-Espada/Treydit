package com.irgek.Treydit.presentation.api;

import com.irgek.Treydit.domain.Country;
import com.irgek.Treydit.domain.Treyder;
import com.irgek.Treydit.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor

@RestController
@RequestMapping(CountryRestController.BASE_URL)
@CrossOrigin
public class CountryRestController {

    public static final String BASE_URL = "/api/country/";
    public static final String PATH_VAR_ID ="/{id}";
    public static final String ROUTE_ID = BASE_URL + PATH_VAR_ID;

    private final CountryService countryService;

    @GetMapping({"/"})
    public HttpEntity<List<Country>> getTreyder(){
        List<Country> countries = countryService.getCountries();

        if(countries.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return  ResponseEntity.ok(countries);
    }

    @PostMapping({"add","/"})
    public HttpEntity<Country> createCountry(@RequestBody Country country){
       Country country1 = countryService.createCountry(country.getName(),country.getIso2Code());
        URI self = UriComponentsBuilder.fromPath(ROUTE_ID)
                .uriVariables(Map.of("id", country1.getId()))
                .build().toUri();
        return  ResponseEntity.created(self).body(country1);
    }

}
