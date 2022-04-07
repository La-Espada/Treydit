package com.irgek.Treydit.presentation.api.registration;

import com.irgek.Treydit.domain.Gender;
import com.irgek.Treydit.domain.Role;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String firstName;
    private final String lastName;
    private final String username;
    private final String password;
    private final String email;
    private final LocalDate BirthDate;
    private final Gender gender;
}
