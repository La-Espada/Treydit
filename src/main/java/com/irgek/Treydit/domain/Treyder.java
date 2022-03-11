package com.irgek.Treydit.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "treyder")
public class Treyder extends AbstractPersistable<Long> {

    private String firstname;
    private String lastname;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String username;
    private String email;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Reputation reputation;
    @Embedded
    private Address address;
    private String phonenumber;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToOne
    private City city;
    @OneToMany
    private List<Item> items = new ArrayList<>();


}
