package com.irgek.Treydit.domain;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Embeddable
public class Address {
    private String street;
    private int housenumber;
    private int blocknumber;
    private int doornumber;
    private int zipcode;
}
