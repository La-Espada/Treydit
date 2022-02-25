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
public class Name {
    private String firstname;
    private String subname;
    private String lastname;
}
