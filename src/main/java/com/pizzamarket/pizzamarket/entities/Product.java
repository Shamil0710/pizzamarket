package com.pizzamarket.pizzamarket.entities;

import lombok.*;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * Сущность отображающая продукт
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "product", schema = "mampiza")
public class Product implements Serializable {

    /**
     * id продукта
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    /**
     * Цена продукта
     */
    @NonNull
    @Column(name = "cost")
    private BigDecimal cost;

    /**
     * Название товара
     */
    @NonNull
    @Column(name = "title")
    private String title;

    /**
     * Описание товара
     */
    @Column(name = "description")
    private String description;

    /**
     * Тег типа товара
     */
    @Column(name = "tag")
    private String tag;
}
