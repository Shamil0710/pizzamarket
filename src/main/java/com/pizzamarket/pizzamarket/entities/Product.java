package com.pizzamarket.pizzamarket.entities;

import lombok.*;

import javax.persistence.*;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    @NonNull
    private BigDecimal cost;

    @Column
    @NonNull
    private String title;

    @Column
    private String description;

    @Column
    private String tag;
}
