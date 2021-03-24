package com.pizzamarket.pizzamarket.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

//todo: analogichno
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "order", schema = "mampiza")
public class Order {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "order_id")
   private Long id;

   @NotNull
   //    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   //    @JoinColumn(name = "shop_log_id")
   //Много заказов один юсер
   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @JoinColumn(name = "user_id")
   private User user;

   @OneToMany
   @JoinColumn(name = "product_id", referencedColumnName = "order_id")
   private List<Product> products;

   @Column(name = "time_of_ordering")
   private Instant timeOfOrdering;

   @Column(name = "cost")
   private BigDecimal cost;
}
