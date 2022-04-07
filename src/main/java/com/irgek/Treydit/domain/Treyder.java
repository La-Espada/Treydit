package com.irgek.Treydit.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "treyder")
public class Treyder extends AbstractPersistable<Long> implements UserDetails {
    private LocalDateTime created;
    private LocalDateTime updated;
    private Boolean locked = false;
    private Boolean enabled = false;
    private String firstname;
    private String lastname;
    @Enumerated(EnumType.STRING)
    private Gender gender;
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

    public Treyder(String firstName, String lastName, String username, String password, String email, LocalDate birthDate, Gender gender,Role role) {
        this.firstname = firstName;
        this.lastname = lastName;
        //this.username = username;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
        this.gender = gender;
        this.role = role;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getUsername() {
        return email;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
