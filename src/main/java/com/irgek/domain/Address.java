package com.irgek.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String addressName;
    private int housenumber;
    private int blocknumber;
    private int doornumber;
    private int zipcode;
}
