package com.pizzamarket.pizzamarket.entities;

import lombok.*;

import javax.persistence.*;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "product", schema = "mampiza")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NonNull
    @Column
    private BigDecimal cost;

    @NonNull
    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String tag;
}
