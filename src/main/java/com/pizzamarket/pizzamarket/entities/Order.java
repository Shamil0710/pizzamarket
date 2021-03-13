package com.pizzamarket.pizzamarket.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

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
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long id;

   @NotNull
   @Column
   //    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   //    @JoinColumn(name = "shop_log_id")
   //Много заказов один юсер
   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @JoinColumn(name = "user_id")
   private User user;

   @OneToMany
   @JoinColumn(name = "product_id", referencedColumnName = "order_id")
   private List<Product> products;

   @Column
   private Instant timeOfOrdering;

   @Column
   private BigDecimal cost;
}
