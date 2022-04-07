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
    private String housenumber;
    private String blocknumber;
    private String doornumber;
    private String zipcode;
}
