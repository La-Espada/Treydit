package com.irgek.Treydit.service.dto;

import com.irgek.Treydit.domain.Category;
import com.irgek.Treydit.domain.Condition;
import com.irgek.Treydit.domain.Treyder;
import lombok.Builder;
import lombok.Getter;


import java.time.LocalDateTime;

@Getter
@Builder
public class MutateItemCommand {
    private LocalDateTime created;
    private LocalDateTime updated;
    private String name;
    private double cost;
    private String description;
    private Condition itemCondition;
    private Category category;
    private Treyder treyder;
}
