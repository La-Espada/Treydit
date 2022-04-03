package com.irgek.Treydit.service.dto;

import com.irgek.Treydit.domain.Country;
import lombok.Getter;


import java.time.LocalDateTime;

@Getter
public class MutateCityCommand {
    private LocalDateTime created;
    private LocalDateTime updated;
    private String name;
    private Country country;
}
