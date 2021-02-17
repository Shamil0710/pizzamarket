package com.pizzamarket.pizzamarket.services;

import com.pizzamarket.pizzamarket.dto.InputProductDto;
import com.pizzamarket.pizzamarket.entities.Product;
import com.pizzamarket.pizzamarket.entities.User;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    /**
     * Сохранение нового продукта
     * @param inputProductDto
     * @return
     */
    Product saveProduct(InputProductDto inputProductDto);

    /**
     * Метод удаление продукта по ID
     * @param id
     */
    void deleteById(Long id);

    /**
     * Обновление товара
     * @param inputProductDto
     */
    void upgradeUProduct(InputProductDto inputProductDto);

    /**
     * Поиск товара по ID
     * @param id
     * @return
     */
    Optional<Product> findById(Long id);

    /**
     * Получение всех продуктов
     * @return
     */
    List<Product> findAll();
}
