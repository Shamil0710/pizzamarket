package com.pizzamarket.pizzamarket.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Order {

   @Id
   @GeneratedValue
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
}
