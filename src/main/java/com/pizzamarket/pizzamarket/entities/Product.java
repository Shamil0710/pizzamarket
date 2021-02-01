package com.pizzamarket.pizzamarket.entities;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import org.springframework.data.annotation.Id;


import javax.persistence.GeneratedValue;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    @NonNull
    private Long cost;
    @Column
    @NonNull
    private String title;
    @Column
    private String description;
    @Column
    private String teg;
}
