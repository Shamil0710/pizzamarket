package com.pizzamarket.pizzamarket.repositorys;

import com.pizzamarket.pizzamarket.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Репозиторий для работы с продуктами
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllByTagIn(List<String> tags, Pageable pageable);

}
