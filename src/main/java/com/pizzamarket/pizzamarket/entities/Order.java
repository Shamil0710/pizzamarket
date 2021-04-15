package com.pizzamarket.pizzamarket.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Сущность отображающая заказ
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "order", schema = "mampiza")
public class Order {

   /**
    * Id заказа
    */
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "order_id")
   private Long id;

   /**
    * Пользователь которому пренадлежит заказ
    */
   @NotNull
   //    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   //    @JoinColumn(name = "shop_log_id")
   //Много заказов один юсер
   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @JoinColumn(name = "user_id")
   private User user;

   /**
    * Список продуктов в заказе
    */
   @OneToMany(cascade = CascadeType.MERGE) //TODO создать таблицу @OneToMany по аналогии с ролями в юсере
//   @JoinColumn(name = "product_id", referencedColumnName = "order_id")
   @JoinTable(name = "order_product",
   joinColumns = {@JoinColumn(name = "order_id")},
   inverseJoinColumns = {@JoinColumn(name = "product_id")})
   private List<Product> products = new ArrayList<>();

   /**
    * Время создания заказа
    */
   @Column(name = "time_of_ordering")
   private Instant timeOfOrdering;

   /**
    * Стоимость заказа
    */
   @Column(name = "cost")
   private BigDecimal cost;
}
