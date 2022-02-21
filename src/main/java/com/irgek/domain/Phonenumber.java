package com.irgek.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Phonenumber {
    private int country_code;
    private int serialnumber;
}
