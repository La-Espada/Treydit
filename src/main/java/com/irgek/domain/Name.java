package com.irgek.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class Name {
    private String firstname;
    private String subname;
    private String lastname;
}
