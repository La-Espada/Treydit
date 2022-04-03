package com.irgek.Treydit.service.dto;

import com.irgek.Treydit.domain.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record TreyderDto(Long id, String firstname, String lastname, Gender gender, String username, String email, LocalDate birthDate, Reputation reputation, Address address, String phonenumber, String password, Role role, City city, LocalDateTime created, LocalDateTime updated) {
    public TreyderDto(Treyder treyder){
        this(treyder.getId(),treyder.getFirstname(),treyder.getLastname(),treyder.getGender(), treyder.getUsername(), treyder.getEmail(), treyder.getBirthDate(),treyder.getReputation(),treyder.getAddress(),treyder.getPhonenumber(),treyder.getPassword(),treyder.getRole(),treyder.getCity(),treyder.getCreated(),treyder.getUpdated());
    }
}
