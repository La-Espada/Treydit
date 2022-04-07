package com.irgek.Treydit.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "item")
public class Item extends AbstractPersistable<Long> {
    private LocalDateTime created;
    private LocalDateTime updated;

    //NotNull(message = "Name can not be null")
    //@NotBlank(message = "Name can not be blank")
    //@NotEmpty(message = "Name can not be empty")
    private String name;
    private double cost;

    //@NotNull(message = "Description can not be null")
    //@NotBlank(message = "Description can not be blank")
    //@NotEmpty(message = "Description can not be empty")
    private String description;

    //@NotNull(message = "Condition can not be null")
    @Enumerated(EnumType.STRING)
    private Condition itemCondition;

    //@NotNull(message = "Category can not be null")
    @Enumerated(EnumType.STRING)
    private Category category;

    //@NotNull(message = "Treyder can not be null")
    @ManyToOne
    private Treyder treyder;
}
