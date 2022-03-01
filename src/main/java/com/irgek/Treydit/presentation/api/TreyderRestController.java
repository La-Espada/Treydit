package com.irgek.Treydit.presentation.api;


import com.irgek.Treydit.domain.*;
import com.irgek.Treydit.service.TreyderService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor

@RestController
@RequestMapping(TreyderRestController.BASE_URL)
@CrossOrigin
public class TreyderRestController {

    public static final String BASE_URL = "/api/treyder";
    public static final String PATH_INDEX = "/";
    public static final String PATH_VAR_ID ="/{id}";
    public static final String ROUTE_ID = BASE_URL + PATH_VAR_ID;

    private final TreyderService treyderService;

    @GetMapping({"",PATH_INDEX})
    public HttpEntity<List<Treyder>> getTreyder(){
        List<Treyder> treyders = treyderService.getTreyders();

        if(treyders.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return  ResponseEntity.ok(treyders);
    }

    @GetMapping({PATH_VAR_ID})
    public HttpEntity<Treyder> getTreyderbyId(@PathVariable long id){
        return treyderService.getTreyderbyId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping({"add",PATH_INDEX})
    public HttpEntity<Treyder> createTreyder(@RequestBody Name name, Gender gender, String username, String email, LocalDate birthDate, Address address, Phonenumber phonenumber, String password, Role role, City city){
        Treyder treyder = treyderService.createTreyder(name,gender, username,email, birthDate, address,phonenumber,password, role, city);
        URI self = UriComponentsBuilder.fromPath(ROUTE_ID)
                .uriVariables(Map.of("id", treyder.getId()))
                .build().toUri();

        return  ResponseEntity.created(self).body(treyder);
    }
}
