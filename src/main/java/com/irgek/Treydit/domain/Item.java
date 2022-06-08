package com.irgek.Treydit.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;

    private double cost;

    @Enumerated(EnumType.STRING)
    private Condition condition;

    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToOne
    @JsonIgnore
    private Treyder treyder;

    private String photo;

    private LocalDateTime created;
    private LocalDateTime updated;

    public Item(String name, String description, double cost, Condition condition, Category category, Treyder treyder,String filename) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.condition = condition;
        this.category = category;
        this.treyder = treyder;
        this.photo = filename;

    }
}
