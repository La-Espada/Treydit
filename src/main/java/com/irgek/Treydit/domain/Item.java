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
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private double cost;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private Condition condition;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToOne
    private Treyder treyder;

    private LocalDateTime created;
    private LocalDateTime updated;

}
