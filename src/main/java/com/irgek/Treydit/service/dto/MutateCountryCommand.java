package com.irgek.Treydit.service.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter

public class MutateCountryCommand {
    private LocalDateTime created;
    private LocalDateTime updated;
    private String name;
    private String iso2Code;
}
