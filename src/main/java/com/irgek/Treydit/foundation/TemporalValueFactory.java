package com.irgek.Treydit.foundation;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TemporalValueFactory {
    public LocalDateTime created_at(){
        return LocalDateTime.now();
    }

    public LocalDateTime replaced_at(){
        return LocalDateTime.now();
    }

    public LocalDateTime deleted_at(){
        return LocalDateTime.now();
    }
}
