package com.pizzamarket.pizzamarket.entities;

import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;
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
   @OneToMany
   @JoinColumn(name = "product_id", referencedColumnName = "order_id")
   private List<Product> products;

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
