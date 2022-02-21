package com.irgek.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name ="country")
public class Country extends AbstractPersistable<Long> {
    private String name;
    private String iso2Code;
    private int countryNumber;
    @OneToMany
    List<City> cities = new ArrayList<>();
}
