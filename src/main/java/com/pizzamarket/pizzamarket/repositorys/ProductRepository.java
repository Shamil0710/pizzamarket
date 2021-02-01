package com.pizzamarket.pizzamarket.repositorys;

import com.pizzamarket.pizzamarket.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
