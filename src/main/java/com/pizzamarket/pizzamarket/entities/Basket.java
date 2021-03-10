package com.pizzamarket.pizzamarket.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Basket {

    @Column
    @NonNull
    private User user;
    @Column
    private List<Product> products;
}
