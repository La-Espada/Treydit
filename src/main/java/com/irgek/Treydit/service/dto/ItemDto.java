package com.irgek.Treydit.service.dto;

import com.irgek.Treydit.domain.Category;
import com.irgek.Treydit.domain.Condition;
import com.irgek.Treydit.domain.Item;
import com.irgek.Treydit.domain.Treyder;

import java.time.LocalDateTime;

public record ItemDto(Long id, String name, double cost, String description, Condition condition, Category category, Treyder treyder, LocalDateTime created, LocalDateTime updated) {
    public ItemDto(Item item){
        this(item.getId(), item.getName(),item.getCost(),item.getDescription(),item.getItemCondition(),item.getCategory(),item.getTreyder(),item.getCreated(),item.getUpdated());
    }
}
