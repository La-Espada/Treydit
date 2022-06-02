package com.irgek.Treydit.payload.request;

import com.irgek.Treydit.domain.Category;
import com.irgek.Treydit.domain.Condition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemRequest {

    private String name;
    @NotBlank
    private String description;

    private double cost;

    @Enumerated(EnumType.STRING)
    private Condition condition;

    @Enumerated(EnumType.STRING)
    private Category category;
}
