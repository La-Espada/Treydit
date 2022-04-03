package com.irgek.Treydit.service.dto;

import com.irgek.Treydit.domain.*;
import lombok.Getter;


import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
public class MutateTreyderCommand {
    private LocalDateTime created;
    private LocalDateTime updated;
    private String firstname;
    private String lastname;
    private Gender gender;
    private String username;
    private String email;
    private LocalDate birthDate;
    private Reputation reputation;
    private Address address;
    private String phonenumber;
    private String password;
    private Role role;
    private City city;
}
