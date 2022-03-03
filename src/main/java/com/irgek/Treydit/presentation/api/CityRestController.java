package com.irgek.Treydit.presentation.api;

import com.irgek.Treydit.domain.City;
import com.irgek.Treydit.domain.Country;
import com.irgek.Treydit.service.CityService;
import com.irgek.Treydit.service.CountryService;
import com.irgek.Treydit.service.TreyderService;
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
@RequestMapping(CityRestController.BASE_URL)
@CrossOrigin
public class CityRestController {

    public static final String BASE_URL = "/api/city";
    public static final String PATH_VAR_ID ="{id}";
    public static final String ROUTE_ID = BASE_URL + PATH_VAR_ID;

    private final CityService cityService;
    private final CountryService countryService;

    @GetMapping({"/"})
    public HttpEntity<List<City>> getCountries(){
        List<City> cities = cityService.getCities();

        if(cities.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return  ResponseEntity.ok(cities);
    }

    @PostMapping({"add","/"})
    public HttpEntity<City> addCity(@RequestBody String name, Long country_id){
        Country country = countryService.getCountryById(country_id);
        System.out.println(country.getName());
        City city = cityService.createCity(name,country);
        URI self = UriComponentsBuilder.fromPath(ROUTE_ID)
                .uriVariables(Map.of("id", city.getId()))
                .build().toUri();

        return  ResponseEntity.created(self).body(city);
    }
}
